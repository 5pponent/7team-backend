package team7.capstone.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team7.capstone.domain.JoinVO;
import team7.capstone.domain.LoginVO;
import team7.capstone.domain.UserVO;
import team7.capstone.service.LoginService;
import team7.capstone.web.ResponseErrors;
import team7.capstone.web.etc.SessionConst;
import team7.capstone.web.exceptions.AccountMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static team7.capstone.web.ResponseForm.badRequest;
import static team7.capstone.web.ResponseForm.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/join")
    public Object join(@Validated @RequestBody JoinVO form, BindingResult bindingResult) {

        // 검증 로직
        ResponseErrors errors = new ResponseErrors();
        if (!form.passwordCheck()) {
            bindingResult.addError(new FieldError(
                    "form", "passwordCheck", "비밀번호가 불일치합니다."));
        }
        if (loginService.idCheck(form.getId())) {
            bindingResult.addError(new FieldError(
                    "form", "id", "이미 존재하는 아이디입니다."));
        }
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().stream()
                    .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
            log.info("errors={}", errors.toString());
            return badRequest(errors);
        }

        // 회원가입
        UserVO user = loginService.join(form);
        log.info("유저[{}] 회원가입", user.getUser_seq());
        return ok(user);
    }

    @PostMapping("/login")
    public Object login(@Validated @RequestBody LoginVO form, BindingResult bindingResult,
                        HttpServletRequest request) {
        // 검증 로직
        ResponseErrors errors = new ResponseErrors();
        if (bindingResult.hasErrors()) {
            log.info("errors={}", errors.toString());
            bindingResult.getFieldErrors().stream()
                    .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
            return badRequest(errors);
        }

        // 로그인
        UserVO user = loginService.login(form);
        if (user == null) {
            throw new AccountMismatchException("아이디/비밀번호를 확인해주세요.");
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user.getUser_seq());
        log.info("유저[{}] 로그인", session.getAttribute(SessionConst.LOGIN_USER));
        return ok(user);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        log.info("유저[{}] 로그아웃", request.getSession().getAttribute(SessionConst.LOGIN_USER));
        request.getSession(false).invalidate();
        return;
    }

}
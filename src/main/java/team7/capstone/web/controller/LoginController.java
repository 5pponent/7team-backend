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
import team7.capstone.repository.user.UserRepository;
import team7.capstone.service.LoginService;
import team7.capstone.web.ResponseError;
import team7.capstone.web.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping("/join")
    public Object join(@Validated @RequestBody JoinVO form, BindingResult bindingResult) {

        // 검증 로직
        ResponseError errors = new ResponseError();
        if (form.getPassword() != null && form.getPasswordCheck() != null) {
            if (!form.getPassword().equals(form.getPasswordCheck())) {
                bindingResult.addError(new FieldError(
                        "form", "passwordCheck", "비밀번호가 불일치합니다."));
            }
        }
        if (form.getId() != null && userRepository.findById(form.getId()).isPresent()) {
            bindingResult.addError(new FieldError(
                    "form", "id", "이미 존재하는 아이디입니다."));
        }
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().stream()
                    .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
            log.info("errors={}", bindingResult.getAllErrors());
            // 검증 오류 발생 시 필드명과 오류메시지를 담아서 json 반환
            return errors;
        }
        UserVO user = loginService.join(form);
        log.info("유저[{}] 회원가입", user.getUser_seq());
        return user;
    }

    @PostMapping("/login")
    public Object login(@Validated @RequestBody LoginVO form, BindingResult bindingResult,
                        HttpServletRequest request) {

        // 검증 로직
        ResponseError errors = new ResponseError();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().stream()
                    .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
            return errors;
        }
        UserVO user = loginService.login(form);
        if (user == null) {
            errors.put("global", "아이디/비밀번호를 확인해주세요");
            return errors;
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user.getUser_seq());
        log.info("유저[{}] 로그인", session.getAttribute(SessionConst.LOGIN_USER));
        return user;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        log.info("유저[{}] 로그아웃", request.getSession().getAttribute(SessionConst.LOGIN_USER));
        request.getSession(false).invalidate();
        return;
    }

}
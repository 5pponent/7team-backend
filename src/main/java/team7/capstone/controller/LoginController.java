package team7.capstone.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team7.capstone.domain.LoginVO;
import team7.capstone.domain.UserVO;
import team7.capstone.repository.user.UserRepository;
import team7.capstone.service.LoginService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping("/join")
    public UserVO join(@RequestBody UserVO user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public UserVO login(@RequestBody LoginVO loginVO) {

        log.info("login info = {}", loginVO);
        UserVO user = loginService.login(loginVO);

        return user;
    }

}
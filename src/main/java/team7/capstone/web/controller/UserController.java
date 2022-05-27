package team7.capstone.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team7.capstone.domain.vo.LoginVO;
import team7.capstone.domain.vo.UserVO;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public String Register(UserVO user) {
        return "";
    }

    @PostMapping
    public String login(LoginVO user) {
        return "";
    }

    @DeleteMapping
    public String delete(UserVO user) {
        return "";
    }

}
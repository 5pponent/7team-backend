package team7.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team7.capstone.domain.UserVO;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /* 회원가입 등록 */
    @PostMapping("/register")
    public String RegisterPOST(UserVO user) {

        return "";
    }

    /* 아이디 중복 검사 */
    @PostMapping("/user_idCk")
    public String user_idCkPOST(String user_id) {
        return "";
    }

    /* 로그인 */
    @PostMapping("login")
    public String loginPOST(UserVO user) {
        return "ok";
    }

    /* 탈퇴 */
    @PostMapping("/delete")
    public void deletePOST(UserVO user) {

    }

}
package team7.capstone.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team7.capstone.domain.LoginVO;
import team7.capstone.domain.UserVO;

@SpringBootTest
@Transactional
class LoginServiceTest {

    @Autowired
    LoginService loginService;

    @Test
    void login() {
        //given
        LoginVO userExsists = new LoginVO();
        LoginVO userNotExists = new LoginVO();
        userExsists.setId("bbb"); userExsists.setPassword("bbb");
        userNotExists.setId("aaa"); userNotExists.setPassword("aaad");

        //when
        UserVO loginUser = loginService.login(userExsists);
        UserVO notUser = loginService.login(userNotExists);

        //then
        Assertions.assertThat(loginUser.getId()).isEqualTo(userExsists.getId());
        Assertions.assertThat(loginUser.getPassword()).isEqualTo(userExsists.getPassword());
        Assertions.assertThat(notUser).isNull();
    }
}
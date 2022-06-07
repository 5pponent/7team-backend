package team7.capstone.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor
public class UserVO {

    private Long user_seq;
    private String id;
    private String password;
    private String name;
    private String email;
    private String job;
    private String category;
    private String image;

    public UserVO(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}

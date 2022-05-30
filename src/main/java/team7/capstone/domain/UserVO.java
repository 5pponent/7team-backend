package team7.capstone.domain;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class UserVO {

    private Long user_seq;

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private String job;
    private String category;
    private String image;

    public UserVO() {
    }

    public UserVO(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}

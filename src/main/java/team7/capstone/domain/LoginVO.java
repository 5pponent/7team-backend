package team7.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class LoginVO {

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    public LoginVO() {
    }

    public LoginVO(String id, String password) {
        this.id = id;
        this.password = password;
    }
}

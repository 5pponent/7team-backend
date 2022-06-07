package team7.capstone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class JoinVO {

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordCheck;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    public boolean passwordCheck() {
        return this.password.equals(this.passwordCheck);
    }

}

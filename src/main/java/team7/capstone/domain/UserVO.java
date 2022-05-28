package team7.capstone.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class UserVO {

    private Long user_seq;
    private String id;
    private String password;
    private String name;
    private String email;
    private String job;
    private String category;
    private String image;
}

package team7.capstone.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class UserVO {

    private String user_id;
    private String password;
    private String name;
    private int gender;
    private String email;
    private String job;
    private String category;
    private int grade;
    private String image;
}

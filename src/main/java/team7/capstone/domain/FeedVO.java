package team7.capstone.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter @Setter
public class FeedVO {

    private Long feed_seq;

    @NotNull
    private Long user_seq;

    private String writer_name;

    @NotBlank
    private String content;
    private Date datetime;
}

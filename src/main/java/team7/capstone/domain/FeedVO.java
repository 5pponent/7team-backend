package team7.capstone.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter @Setter @ToString
public class FeedVO {

    private Long feed_seq;
    private Long user_seq;
    private String writer_name;
    private String content;
    private Date datetime;
}

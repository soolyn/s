package org.codenova.tolkhub.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Posts {
    private int id;
    private String writerId;
    private String category;
    private String title;
    private String content;
    private int views;
    private int likes;
    private Date writedAt;
    private Date modifiedAt;

}

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

public class User {
    private String id;
    private String password;
    private String nickname;
    private String gender;
    private int birth;
    private Date createAt;
}

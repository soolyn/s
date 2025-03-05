package org.codenova.tolkhub.model.vo;

import java.util.Date;

public class User {
    private String id;
    private String password;
    private String nickname;
    private String gander;
    private int birth;
    private Date createAt;

    public User() {
    }

    public User(String id, String password, String nickname, String gander, int birth, Date createAt) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.gander = gander;
        this.birth = birth;
        this.createAt = createAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}

package com.elte.fsz.takemybook.application.webdomain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ProfileForm {
    private long id;
    @NotEmpty(message = "Nickname may not be empty.")
    private String nickname;
    @Email(message = "Email must be correct.")
    @NotEmpty(message = "Email must be added.")
    private String email;

    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

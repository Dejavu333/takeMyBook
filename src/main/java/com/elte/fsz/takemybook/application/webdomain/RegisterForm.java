package com.elte.fsz.takemybook.application.webdomain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterForm {
    @NotEmpty(message = "Username may not be empty.")
    @Size(min = 4, message = "Username may be at least 4 characters.")
    private String username;
    @NotEmpty(message = "Password may not be empty.")
    @Size(min = 3, message = "Password may be at least 3 characters.")
    private String password;
    @NotEmpty(message = "Password may not be empty.")
    private String passwordAgain;
    @NotEmpty(message = "Nickname may not be empty.")
    private String nickName;
    private String phone;
    @NotEmpty(message = "Email may not be empty.")
    @Email(message = "Email must be correct.")
    private String email;
    private Double inlon;
	private Double inlat;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Double getInlon() {
		return inlon;
	}

	public void setInlon(Double inlon) {
		this.inlon = inlon;
	}

	public Double getInlat() {
		return inlat;
	}

	public void setInlat(Double inlat) {
		this.inlat = inlat;
	}

}
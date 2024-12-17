package com.example.sample;

import com.example.comman.CustomConstraint;
import jakarta.validation.constraints.NotBlank;


public class LoginForm {

    @NotBlank(message = "{error.empty}")
    private String userName;
    @CustomConstraint
    private String password;
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm [userName=" + userName + ", password=" + password + "]";
    }
}

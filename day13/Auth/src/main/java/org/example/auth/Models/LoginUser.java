package org.example.auth.Models;

import jakarta.validation.constraints.*;

public class LoginUser {

    @NotBlank(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String loginEmail;

    @NotBlank(message="Password is required!")
    @Size(min = 8, message = "password must be more than 8 characters")
    private String loginPassword;

    public LoginUser() {}

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

}

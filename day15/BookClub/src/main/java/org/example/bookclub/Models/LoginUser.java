package org.example.bookclub.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

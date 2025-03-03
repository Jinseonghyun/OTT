package com.backend.ott.controller.user.request;

import com.backend.ott.annotation.PasswordEncryption;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegisterRequest {

    private String username;

    @PasswordEncryption
    private String password;

    private String email;
    private String phone;

    public UserRegisterRequest(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}

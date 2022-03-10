package com.dogood.dogoodtest.dto;

public class UserRequest {

    private String username;

    private String password;

    private String rol;

    public UserRequest(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public String getRol() {
        return rol;
    }

    public String getPassword() {
        return password;
    }
}

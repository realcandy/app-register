package com.paynet.entity;

/**
 * Created by Dev1 on 20.12.2019.
 */
public class JwtToken {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtToken(String token) {
        this.token = token;
    }

    public JwtToken() {
    }
}

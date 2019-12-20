package com.paynet.service;

import com.paynet.entity.JwtToken;
import com.paynet.entity.User;
import io.jsonwebtoken.Claims;

import java.util.function.Function;

/**
 * Created by Dev1 on 20.12.2019.
 */
public interface JwtAuthenticationService {
    JwtToken generateToken(User user);

    boolean isValid(User user, JwtToken jwtToken);

    <T> T getClaimFromToken(JwtToken jwtToken, Function<Claims, T> claimsResolver);
}

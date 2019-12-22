package com.paynet.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

/**
 * Created by Dev1 on 20.12.2019.
 */
public interface JwtAuthenticationService {
    String generate(UserDetails userDetails);

    boolean validate(String token, UserDetails userDetails);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);
}

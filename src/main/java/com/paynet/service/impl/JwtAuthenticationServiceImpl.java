package com.paynet.service.impl;

import com.paynet.service.JwtAuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.function.Function;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service
public class JwtAuthenticationServiceImpl implements JwtAuthenticationService {
    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String generate(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    @Override
    public boolean validate(String token, UserDetails userDetails) {
        final String login = getClaimFromToken(token, Claims::getSubject);
        if (StringUtils.isEmpty(login))
            throw new AuthorizationServiceException("Invalid user login! Failed to validate token");
        return login.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public  <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        return claimsResolver.apply(claims);
    }

    private boolean isTokenExpired(String token) {
        return getClaimFromToken(token, Claims::getExpiration).before(new Date());
    }
}

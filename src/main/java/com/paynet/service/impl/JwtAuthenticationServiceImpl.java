package com.paynet.service.impl;

import com.paynet.entity.JwtToken;
import com.paynet.entity.User;
import com.paynet.service.JwtAuthenticationService;
import com.paynet.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AuthorizationServiceException;
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
    @Autowired
    private UserService userService;

    @Override
    public JwtToken generateToken(User user) {
        User userDetails = userService.findUser(user);
        if (userDetails == null)
            throw new AuthorizationServiceException("Invalid user! User does not exist");

        return new JwtToken(Jwts.builder()
                .setSubject(userDetails.getLogin())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact())
                ;
    }

    @Override
    public boolean isValid(User user, JwtToken jwtToken) {
        final String login = getClaimFromToken(jwtToken, Claims::getSubject);
        if (StringUtils.isEmpty(login))
            throw new AuthorizationServiceException("Invalid user login! Failed to validate token");
        return login.equals(user.getLogin()) && !isTokenExpired(jwtToken);
    }

    public  <T> T getClaimFromToken(JwtToken jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken.getToken()).getBody();

        return claimsResolver.apply(claims);
    }

    private boolean isTokenExpired(JwtToken jwtToken) {
        return getClaimFromToken(jwtToken, Claims::getExpiration).before(new Date());
    }
}

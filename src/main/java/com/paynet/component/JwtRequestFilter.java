package com.paynet.component;

import com.paynet.entity.JwtToken;
import com.paynet.entity.User;
import com.paynet.service.JwtAuthenticationService;
import com.paynet.service.UserService;
import io.jsonwebtoken.Claims;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dev1 on 20.12.2019.
 */

//TODO Refactor
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    private JwtAuthenticationService jwtAuthenticationService;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        JwtToken jwtToken = null;
        String login = null;
        if (StringUtils.isEmpty(authorizationHeader) && authorizationHeader.startsWith("Bearer")) {
            jwtToken = new JwtToken(authorizationHeader.substring(7));
            login = jwtAuthenticationService.getClaimFromToken(jwtToken, Claims::getSubject);
        } else
            logger.warn("JWT Token does not begin with Bearer");

        User user = userService.findUserByLogin(new User(login));

        if (jwtAuthenticationService.isValid(user, jwtToken)) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null));
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

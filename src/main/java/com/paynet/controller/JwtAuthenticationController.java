package com.paynet.controller;

import com.paynet.model.JwtRequest;
import com.paynet.model.JwtResponse;
import com.paynet.service.JwtAuthenticationService;
import com.paynet.validator.JwtRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Dev1 on 20.12.2019.
 */
@RestController
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAuthenticationService jwtAuthenticationService;

    @Autowired
    @Qualifier("applicationUserDetailsService")
    private UserDetailsService userDetailsService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new JwtRequestValidator());
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody @Valid JwtRequest jwtRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        if (!authentication.isAuthenticated())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

        return ResponseEntity.ok(new JwtResponse(jwtAuthenticationService.generate(userDetails)));
    }
}

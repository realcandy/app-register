package com.paynet.entity;

import java.util.HashSet;

public class ApplicationUserDetails extends org.springframework.security.core.userdetails.User {
    public ApplicationUserDetails(ApplicationUser user) {
        super(user.getUsername(), user.getPassword(), new HashSet<>());
    }
}
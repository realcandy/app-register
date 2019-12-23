package com.paynet.service.impl;

import com.paynet.entity.ApplicationUser;
import com.paynet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service("applicationUserDetailsService")
public class ApplicationUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser user = userService.findUserByLogin(s);
        if (user == null)
            return null;
        return new ApplicationUserDetails(user);
    }

    public class ApplicationUserDetails extends org.springframework.security.core.userdetails.User {

        ApplicationUserDetails(ApplicationUser user) {
            super(user.getUsername(), user.getPassword(), new HashSet<>());
        }
    }
}

package com.paynet.service.impl;

import com.paynet.entity.User;
import com.paynet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new ApplicationUserDetails(userService.findUserByLogin(new User(s)));
    }

    class ApplicationUserDetails extends org.springframework.security.core.userdetails.User {

        ApplicationUserDetails(User user) {
            super(user.getLogin(), user.getPassword(), null);
        }
    }
}

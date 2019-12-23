package com.paynet.service.impl;

import com.paynet.entity.ApplicationUser;
import com.paynet.entity.ApplicationUserDetails;
import com.paynet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}

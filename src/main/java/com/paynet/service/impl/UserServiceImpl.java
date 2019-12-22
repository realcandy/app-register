package com.paynet.service.impl;

import com.paynet.entity.ApplicationUser;
import com.paynet.repository.UserRepository;
import com.paynet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ApplicationUser register(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userRepository.findUser(user);
    }

    @Override
    public ApplicationUser update(ApplicationUser user) {
        userRepository.update(user);
        return userRepository.findUser(user);
    }

    @Override
    public ApplicationUser findUser(ApplicationUser user) {
        return userRepository.findUser(user);
    }

    @Override
    public ApplicationUser findUserByLogin(ApplicationUser user) {
        return userRepository.findUserByLogin(user);
    }
}

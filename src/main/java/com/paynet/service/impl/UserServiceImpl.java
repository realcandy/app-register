package com.paynet.service.impl;

import com.paynet.entity.User;
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
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userRepository.findUser(user);
    }

    @Override
    public User update(User user) {
        userRepository.update(user);
        return userRepository.findUser(user);
    }

    @Override
    public User findUser(User user) {
        return userRepository.findUser(user);
    }

    @Override
    public User findUserByLogin(User user) {
        return userRepository.findUserByLogin(user);
    }
}

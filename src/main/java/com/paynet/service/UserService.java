package com.paynet.service;

import com.paynet.entity.User;

/**
 * Created by Dev1 on 20.12.2019.
 */
public interface UserService {
    User register(User user);

    User update(User user);

    User findUser(User user);

    User findUserByLogin(User user);
}

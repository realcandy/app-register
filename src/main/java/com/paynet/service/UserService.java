package com.paynet.service;

import com.paynet.entity.ApplicationUser;

/**
 * Created by Dev1 on 20.12.2019.
 */
//TODO Throw exception if user is already exists
public interface UserService {
    ApplicationUser save(ApplicationUser user);

    ApplicationUser update(ApplicationUser user);

    ApplicationUser findUser(ApplicationUser user);

    ApplicationUser findUserByLogin(String login);
}

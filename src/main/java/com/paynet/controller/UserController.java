package com.paynet.controller;

import com.paynet.entity.User;
import com.paynet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dev1 on 20.12.2019.
 */
@RestController
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }
}

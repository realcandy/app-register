package com.paynet.controller;

import com.paynet.entity.ApplicationUser;
import com.paynet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dev1 on 20.12.2019.
 */
//TODO remove request mapping on controller
@RestController
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ApplicationUser registerUser(@RequestBody ApplicationUser user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ApplicationUser updateUser(@PathVariable Integer id, @RequestBody ApplicationUser user) {
        user.setId(id);
        return userService.update(user);
    }
}

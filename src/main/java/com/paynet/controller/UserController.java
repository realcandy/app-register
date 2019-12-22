package com.paynet.controller;

import com.paynet.entity.ApplicationUser;
import com.paynet.model.UserRequest;
import com.paynet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ApplicationUser registerUser(@RequestBody UserRequest request) {
        return userService.save(request.toUser());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ApplicationUser updateUser(@PathVariable Integer id, @RequestBody UserRequest request) {
        return userService.update(request.toUser(id));
    }
}

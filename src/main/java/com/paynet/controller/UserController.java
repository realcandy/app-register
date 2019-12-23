package com.paynet.controller;

import com.paynet.entity.ApplicationUser;
import com.paynet.model.UserRequest;
import com.paynet.service.UserService;
import com.paynet.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Dev1 on 20.12.2019.
 */
@RestController
public class UserController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ApplicationUser registerUser(@RequestBody @Valid UserRequest request) {
        return userService.save(request.toUser());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
    public ApplicationUser updateUser(@PathVariable Integer id, @RequestBody UserRequest request) {
        return userService.update(request.toUser(id));
    }
}

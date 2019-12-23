package com.paynet.controller;

import com.paynet.entity.ApplicationUser;
import com.paynet.model.ErrorResponse;
import com.paynet.model.UserRequest;
import com.paynet.service.UserService;
import com.paynet.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRequest request) {
        if (userService.findUserByLogin(request.getUsername()) != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("An error occurred, user with the specified username already exists!"));
        return ResponseEntity.ok(userService.save(request.toUser()));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
    public ApplicationUser updateUser(@PathVariable Integer id, @RequestBody UserRequest request) {
        return userService.update(request.toUser(id));
    }
}

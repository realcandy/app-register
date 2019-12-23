package com.paynet.controller;

import com.paynet.entity.Comment;
import com.paynet.model.CommentApplicationRequest;
import com.paynet.service.CommentService;
import com.paynet.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Dev1 on 20.12.2019.
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new CommentValidator());
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment saveComment(@RequestBody @Valid CommentApplicationRequest request) {
        return commentService.save(request.toComment(), request.toApplication());
    }
}

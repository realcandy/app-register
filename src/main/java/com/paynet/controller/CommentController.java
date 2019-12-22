package com.paynet.controller;

import com.paynet.entity.Comment;
import com.paynet.model.CommentRequest;
import com.paynet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dev1 on 20.12.2019.
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment saveComment(@RequestBody CommentRequest request){
        return commentService.save(request.toComment());
    }
}

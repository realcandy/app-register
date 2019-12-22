package com.paynet.service.impl;

import com.paynet.entity.Comment;
import com.paynet.repository.CommentRepository;
import com.paynet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        commentRepository.insert(comment);
        return commentRepository.find(comment);
    }
}

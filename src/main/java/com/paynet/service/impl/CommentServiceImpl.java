package com.paynet.service.impl;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;
import com.paynet.repository.CommentRepository;
import com.paynet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment save(Comment comment, Application application) {
        commentRepository.insert(comment);
        commentRepository.insertCommentApplication(comment, application);
        return commentRepository.find(comment);
    }
}

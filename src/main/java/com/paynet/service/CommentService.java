package com.paynet.service;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;

/**
 * Created by Dev1 on 20.12.2019.
 */
public interface CommentService {
    Comment save(Comment comment, Application application);
}

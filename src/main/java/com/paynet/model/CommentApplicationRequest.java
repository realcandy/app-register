package com.paynet.model;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;

import java.util.Collections;

public class CommentApplicationRequest {
    private CommentRequest comment;
    private ApplicationRequest application;

    public CommentRequest getComment() {
        return comment;
    }

    public void setComment(CommentRequest comment) {
        this.comment = comment;
    }

    public ApplicationRequest getApplication() {
        return application;
    }

    public void setApplication(ApplicationRequest application) {
        this.application = application;
    }

    public Application toApplication() {
        Application application = new Application();
        application.setId(this.application.getId());
        application.setComments(Collections.singletonList(new Comment(comment.getText())));

        return application;
    }
}

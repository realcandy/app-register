package com.paynet.model;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;

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
        return application;
    }

    public Comment toComment() {
        return new Comment(comment.getText());
    }
}

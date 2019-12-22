package com.paynet.model;

import com.paynet.entity.Comment;

public class CommentRequest {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment toComment(){
        return new Comment(text);
    }
}

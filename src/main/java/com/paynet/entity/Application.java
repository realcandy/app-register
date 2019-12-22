package com.paynet.entity;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
public class Application {
    private Long id;
    private String text;
    private String title;
    private List<Comment> comments;

    public Application() {
    }

    public Application(Long id, String text, String title) {
        this.id = id;
        this.text = text;
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

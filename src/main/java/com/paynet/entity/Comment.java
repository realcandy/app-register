package com.paynet.entity;

/**
 * Created by Dev1 on 20.12.2019.
 */
public class Comment {
    private Long id;
    private String text;

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
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

}

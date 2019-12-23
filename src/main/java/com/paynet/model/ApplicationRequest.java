package com.paynet.model;

import com.paynet.entity.Application;

public class ApplicationRequest {
    private Integer id;
    private String title;
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Application toApplication(Integer id){
        Application application = toApplication();
        application.setId(id);
        return application;
    }

    public Application toApplication(){
        return new Application(id, text, title);
    }
}

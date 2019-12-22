package com.paynet.model;

import com.paynet.entity.Application;
import com.paynet.entity.ApplicationUser;

import java.nio.file.attribute.UserPrincipal;

public class ApplicationRequest {
    private Long id;
    private String title;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Application toApplication(long id){
        Application application = toApplication();
        application.setId(id);
        return application;
    }

    public Application toApplication(){
        return new Application(id, text, title);
    }
}

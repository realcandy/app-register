package com.paynet.model;

import com.paynet.entity.ApplicationUser;

import java.util.Date;

public class UserRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private Date dateBirth;
    private String username;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ApplicationUser toUser(){
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setPassword(password);
        applicationUser.setAddress(address);
        applicationUser.setDateBirth(dateBirth);
        applicationUser.setFirstName(firstName);
        applicationUser.setLastName(lastName);
        applicationUser.setUsername(username);

        return applicationUser;
    }

    public ApplicationUser toUser(Integer id){
        ApplicationUser applicationUser = toUser();
        applicationUser.setId(id);
        return applicationUser;
    }
}

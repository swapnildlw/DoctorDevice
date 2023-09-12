package com.stackroute.UserService.model;

import java.util.List;

public class CreateUserRequest {
    private String email;
    private String userName;
    private String password;
    private String address;
    private List<String> gadgetList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public List<String> getGadgetList() {
        return gadgetList;
    }

    public void setGadgetList(List<String> gadgetList) {
        this.gadgetList = gadgetList;
    }

    public CreateUserRequest(String email, String userName, String password, String address, List<String> gadgetList) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.gadgetList = gadgetList;
    }

    public CreateUserRequest() {
    }
}

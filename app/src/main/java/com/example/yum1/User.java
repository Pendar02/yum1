package com.example.yum1;

import java.util.List;

public class User {
    //variables
    private String uid;
    private String name;
    private String email;
    private String address;
    private List<String> faves;
    private List<String> recents;

    //constructor empty
    public User() {
    }
    //constructor
    public User(String uid, String name, String email, String address, List<String> faves, List<String> recents) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.address = address;
        this.faves = faves;
        this.recents = recents;
    }

    //getter and setter

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFaves() {
        return faves;
    }

    public void setFaves(List<String> faves) {
        this.faves = faves;
    }

    public List<String> getRecents() {
        return recents;
    }

    public void setRecents(List<String> recents) {
        this.recents = recents;
    }
}



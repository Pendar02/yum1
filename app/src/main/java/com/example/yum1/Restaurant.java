package com.example.yum1;

import java.util.List;
import java.util.Map;

public class Restaurant {
    //variables
    private String id;
    private String name;
    private String address;
    private String photo;
    private String location;
    private double rating;
    private String cuisines;
    private List<List<Object>> reviews; // [name,rating,review]
    private Map<String, Double> menu;
    private List<Object> operationtime;

    //constructor empty
    public Restaurant() {
    }

    public Restaurant(String id, String name, String address, String photo, String location, double rating, String cuisines, List<List<Object>> reviews, Map<String, Double> menu, List<Object> operationtime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.photo = photo;
        this.location = location;
        this.rating = rating;
        this.cuisines = cuisines;
        this.reviews = reviews;
        this.menu = menu;
        this.operationtime = operationtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public List<List<Object>> getReviews() {
        return reviews;
    }

    public void setReviews(List<List<Object>> reviews) {
        this.reviews = reviews;
    }

    public Map<String, Double> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Double> menu) {
        this.menu = menu;
    }

    public List<Object> getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(List<Object> operationtime) {
        this.operationtime = operationtime;
    }
}


package com.example.yum1;

import java.util.ArrayList;
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
    private String cuisine;
    private ArrayList<String> reviews; // name,rating,review
    private Map<String, Double> menu;
    private ArrayList<Object> operationtime;

    //constructor empty
    public Restaurant() {
    }

    public Restaurant(String id, String name, String address, String photo, String location, double rating, String cuisine, ArrayList<String> reviews, Map<String, Double> menu, ArrayList<Object> operationtime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.photo = photo;
        this.location = location;
        this.rating = rating;
        this.cuisine = cuisine;
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

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<String> getReviews() {

        //String _name = this.reviews.get(0).split(",")[0];
        //double _r =Double.valueOf( this.reviews.get(0).split(",")[1]);
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public Map<String, Double> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Double> menu) {
        this.menu = menu;
    }

    public ArrayList<Object> getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(ArrayList<Object> operationtime) {
        this.operationtime = operationtime;
    }
}
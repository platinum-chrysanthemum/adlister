package com.codeup.adlister.models;

import java.util.List;
public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private List<String> categories;

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }



    public Ad(long userId, String title, String description) {
        this.userId = userId;

    public Ad(long id, long user_Id, String title, String description, List<String> categories) {
        this.id = id;
        this.userId = user_Id;
        this.title = title;
        this.description = description;
        this.categories = categories;
    }

    public Ad(long user_id, String title, String description) {
        this.userId = user_id;

        this.title = title;
        this.description = description;
    }

    public Ad() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

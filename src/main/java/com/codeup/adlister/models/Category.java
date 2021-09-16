package com.codeup.adlister.models;

public class Category {

    private long id;

    private long name;

    public Category() {}

    public Category(long name) {
        this.name = name;
    }

    public Category(long id, long name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Ad;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);


    void update(User user);

    //function to check database if username already exits
    Boolean confirm(User user);

    public List<Ad> getUserAds(long id);


    public Boolean confirm(User user);



}

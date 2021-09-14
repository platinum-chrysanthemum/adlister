package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "DeleteServlet", urlPatterns = "/ads/delete/")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") ==null ) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        long uId = user.getId();
        String pathInfo = request.getPathInfo();
        int adId = Integer.parseInt(pathInfo.substring(1));
        Ad ad = DaoFactory.getAdsDao().getAdById(adId);
        if (uId == ad.getUserId()) {
            DaoFactory.getAdsDao().deleteAd(adId);
            response.sendRedirect("/profile");
            return;
        }
        response.sendRedirect("/profile");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

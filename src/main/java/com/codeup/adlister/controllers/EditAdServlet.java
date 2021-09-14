package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(name = "EditAdServlet", value = "/ads/edit/")
public class EditAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String pathInfo = request.getPathInfo();
    int adId = Integer.parseInt(pathInfo.substring(1));
        request.setAttribute("ad", DaoFactory.getAdsDao().getAdById(adId));
        request.getRequestDispatcher("WEB-INF/ads/edited.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String pathInfo = request.getPathInfo();
    int adId = Integer.parseInt(pathInfo.substring(1));
    Ad ad =DaoFactory.getAdsDao().getAdById(adId);
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    ad.setTitle(title);
    ad.setDescription(description);
    DaoFactory.getAdsDao().updateAds(ad);
        response.sendRedirect("/profile");
    }
}

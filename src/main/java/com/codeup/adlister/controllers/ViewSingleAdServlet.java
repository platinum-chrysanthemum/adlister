package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.codeup.adlister.util.Redirect.returnAddress;

@WebServlet(urlPatterns = "/ads/view")
public class ViewSingleAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            String address = returnAddress(request.getRequestURL(), request.getQueryString());
            response.sendRedirect("/login?returnTo=" + address);
            return;
        }

        //ID of ad assigned to a variable
        long adId = Long.parseLong(request.getParameter("id"));
        System.out.println(adId);
//
        // This should grab the ad based on its id
        Ad ad = DaoFactory.getAdsDao().getOne(adId);

        request.setAttribute("ad", ad);

        //Should display the singular ad
        request.getRequestDispatcher("/WEB-INF/viewAd.jsp").forward(request, response);


    }


}

package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("ads", DaoFactory.getAdsDao().search("${}"));


        //or
        //response.redirect("/search)?

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //This should be accessing the search function i made in my MySQLAdsDao
        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);


    }
}

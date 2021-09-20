package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name="UpdateProfileServlet", value ="/profile/update")

public class UpdateProfileServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/update.jsp")
                .forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = (User) request.getSession().getAttribute("user");
        user.setUsername(username);
        user.setEmail(email);
        DaoFactory.getUsersDao().update(user);
        response.sendRedirect("/profile");
    }
}

package com.example.controller;

import com.example.dao.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/del-category")
public class DelCategoryController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        new CategoryDAO().del(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/category");
    }
}

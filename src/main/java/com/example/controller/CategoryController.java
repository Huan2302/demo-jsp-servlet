package com.example.controller;

import com.example.dao.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/category")
public class CategoryController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        req.setAttribute("list", new CategoryDAO().findAll());
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }
}

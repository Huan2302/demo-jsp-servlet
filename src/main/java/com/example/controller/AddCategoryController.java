package com.example.controller;

import com.example.dao.CategoryDAO;
import com.example.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-category")
public class AddCategoryController
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("addCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        new CategoryDAO().insert(CategoryModel.builder()
                                              .name(req.getParameter("name"))
                                              .build());
        resp.sendRedirect(req.getContextPath()+"/category");
    }
}

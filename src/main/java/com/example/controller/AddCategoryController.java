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

        String name = req.getParameter("name");
        if (!name.equals("")) {
            new CategoryDAO().insert(CategoryModel.builder()
                                                  .name(name)
                                                  .build());
            req.setAttribute("success", "Thêm thành công");
        } else {
            req.setAttribute("fail", "Thêm thất bại");
        }

        req.setAttribute("list", new CategoryDAO().findAll());
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }
}

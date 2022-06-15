package com.example.controller;

import com.example.dao.CategoryDAO;
import com.example.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/edit-category")
public class UpdateCategory
    extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        CategoryModel categoryModel = new CategoryDAO().findOne(id);

        req.setAttribute("nameold", categoryModel.getName());

        req.getRequestDispatcher("updateCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        if (!name.equals("")) {
            new CategoryDAO().update(CategoryModel.builder()
                                                  .id(id)
                                                  .name(name)
                                                  .build());
            req.setAttribute("success", "Sửa thành công");
        } else {
            req.setAttribute("fail", "Sửa thất bại");
        }

        req.setAttribute("list", new CategoryDAO().findAll());
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }
}

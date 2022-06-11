package com.example.controller;

import com.example.dao.BookDAO;
import com.example.model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-book")
public class AddBookController
        extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String category = req.getParameter("category");

        new BookDAO().insert(BookModel.builder()
                                      .id(id)
                                      .name(name)
                                      .category(category)
                                      .build());
        //bắt buộc mình phải gửi attribute là listBook. mới hiểu
//        req.getRequestDispatcher("home.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/home");
        //req.getContextPath() -> demo_war_exploded/
        //http://localhost:8080/home -> http://localhost:8080/demo_war_exploded/add-book
    }
}

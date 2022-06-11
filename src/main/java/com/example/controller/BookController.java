package com.example.controller;

import com.example.dao.BookDAO;
import com.example.model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/home")
public class BookController
        extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        List<BookModel> list = new BookDAO().findAll();
        req.setAttribute("listBook", list);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}

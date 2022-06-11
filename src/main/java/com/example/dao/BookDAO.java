package com.example.dao;

import com.example.model.BookModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    protected static Connection getConnection()
            throws ClassNotFoundException, SQLException {

        String dbDriver = "org.postgresql.Driver";
        String dbURL = "jdbc:postgresql://localhost:5432/";

        String dbName = "demo";
        String dbUsername = "postgres";
        String dbPassword = "r00t";

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL + dbName,
                                           dbUsername,
                                           dbPassword);
    }

    public List<BookModel> findAll() {
        String sql = "SELECT * FROM book";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();// tạo kết nối đế truy vấn
            ResultSet rs = stmt.executeQuery(sql); // thực thi câu tri vấn

            List<BookModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(BookModel.builder()
                                  .id(rs.getInt("id"))
                                  .name(rs.getString("name"))
                                  .category(rs.getString("category"))
                                  .build());
            }
            return list;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }// 1, sasch a , truyen tranh
    public void insert(BookModel bookModel) {
        String sql = "insert into book(id,name,category) values (?, ?, ?)";
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);

            st.setInt(1, bookModel.getId());
            st.setString(2, bookModel.getName());
            st.setString(3, bookModel.getCategory());
            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

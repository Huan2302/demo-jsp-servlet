package com.example.dao;

import com.example.model.BookModel;
import com.example.model.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO
    extends BaseDAO {
    public List<BookModel> findAll() {
        String sql = "SELECT book.id bid, book.name bname, category.id cid, category.name cname"
            + " FROM book inner join category on book.category_id = category.id";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();// tạo kết nối đế truy vấn
            ResultSet rs = stmt.executeQuery(sql); // thực thi câu tri vấn

            List<BookModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(BookModel.builder()
                                  .id(rs.getInt("bid"))
                                  .name(rs.getString("bname"))
                                  .category(CategoryModel.builder()
                                                         .id(rs.getInt("cid"))
                                                         .name(rs.getString("cname"))
                                                         .build())
                                  .build());
            }
            return list;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }// 1, sasch a , truyen tranh

    public void insert(BookModel bookModel) {
        String sql = "insert into book(name,category_id) values (?, ?)";
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);

            st.setString(1, bookModel.getName());
            st.setInt(2, bookModel.getCategory().getId());
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

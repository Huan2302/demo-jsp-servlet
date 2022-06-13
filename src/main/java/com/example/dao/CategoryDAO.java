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

public class CategoryDAO
    extends BaseDAO {
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();// tạo kết nối đế truy vấn
            ResultSet rs = stmt.executeQuery(sql); // thực thi câu tri vấn

            List<CategoryModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(CategoryModel.builder()
                                      .id(rs.getInt("id"))
                                      .name(rs.getString("name"))
                                      .build());
            }
            return list;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public CategoryModel findOne(int id) {
        String sql = "SELECT * FROM category where id = " + id; //SELECT * FROM category where id = 1
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();// tạo kết nối đế truy vấn
            ResultSet rs = stmt.executeQuery(sql); // thực thi câu tri vấn

            if (rs.next()) {
                return CategoryModel.builder()
                                    .id(rs.getInt("id"))
                                    .name(rs.getString("name"))
                                    .build();
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void insert(CategoryModel categoryModel) {
        String sql = "insert into category(name) values (?)";
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);

            st.setString(1, categoryModel.getName());
            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert st != null;
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

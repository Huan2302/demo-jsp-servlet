package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    public static Connection getConnection()
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
}

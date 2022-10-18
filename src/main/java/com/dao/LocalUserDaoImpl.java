package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalUserDaoImpl extends UserDaoAbstract{
    @Override
    public Connection getConnection() throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/likelion-db","root","password");

        return conn;
    }
}

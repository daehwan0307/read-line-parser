package com.dao;

import domain.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public abstract class UserDaoAbstract {
    public abstract Connection makeConnection() throws SQLException;

    public void add(User user){
        Map<String,String> env = System.getenv();
        try{
            //ㅇDB접속( ex sql workbench실행)
            Connection conn = makeConnection();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


package com.dao;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDaoTest {

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        String id ="12";
        userDao.add(new User(id,"rara","123456"));
        User user = userDao.findById(id);
        Assertions.assertEquals("rara",user.getName());
    }
}
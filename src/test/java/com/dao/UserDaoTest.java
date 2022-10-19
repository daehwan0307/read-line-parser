package com.dao;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDaoTest {

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao(new AWSConnectionMaker());
        String id ="16";
        userDao.add(new User(id,"daara","123456"));
        User user = userDao.findById(id);
        Assertions.assertEquals("daara",user.getName());
    }
}
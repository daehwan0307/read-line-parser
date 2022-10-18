package com.dbexercise;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = new User("9","eoghks","1234");
        userDao.add(user);

        User selectedUser = userDao.findById("9");
        Assertions.assertEquals("eoghks1",selectedUser.getName());



    }
}
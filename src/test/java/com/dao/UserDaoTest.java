package com.dao;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
       // UserDao userDao = new UserDao(new AWSConnectionMaker());
        UserDao userDao = context.getBean("awsUserDao",UserDao.class);
        String id ="17";
        userDao.add(new User(id,"daara","123456"));
        User user = userDao.findById(id);
        Assertions.assertEquals("daara",user.getName());
    }
}
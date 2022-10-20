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
    void addAndGet() throws SQLException, ClassNotFoundException {
       // UserDao userDao = new UserDao(new AWSConnectionMaker());
        UserDao userDao = context.getBean("awsUserDao",UserDao.class);
        userDao.deleteAll();
        Assertions.assertEquals(0,userDao.getCount());

        String id ="1";
        userDao.add(new User(id,"daara","123456"));
        Assertions.assertEquals(1,userDao.getCount());
        User user = userDao.findById(id);
        Assertions.assertEquals("daara",user.getName());
        Assertions.assertEquals("123456",user.getPassword());
    }
}
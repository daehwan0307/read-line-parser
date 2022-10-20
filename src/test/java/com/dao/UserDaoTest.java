package com.dao;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;
    UserDao userDao;
    @BeforeEach
    void setup() {
        this.userDao = context.getBean("awsUserDao", UserDao.class);
    }

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
    @Test
    void findById() {
        Assertions.assertThrows(EmptyResultDataAccessException.class,()->{
            userDao.findById("30");
        });
        //rs.next()에서 null발생

    }
    @Test
    void count() throws  SQLException,ClassNotFoundException{
        User user1 = new User("1","jung","1234");
        User user2 = new User("2","dae","1234");
        User user3 = new User("3","hwan","1234");

        UserDao userDao = context.getBean("awsUserDao",UserDao.class);
        userDao.deleteAll();
        Assertions.assertEquals(0,userDao.getCount());

        userDao.add(user1);
        Assertions.assertEquals(1,userDao.getCount());
        userDao.add(user2);
        Assertions.assertEquals(2,userDao.getCount());
        userDao.add(user3);
        Assertions.assertEquals(3,userDao.getCount());

    }


}
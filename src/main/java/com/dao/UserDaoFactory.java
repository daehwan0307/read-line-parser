package com.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
public class UserDaoFactory {
    @Bean
    public UserDao awsUserDao(){
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
        UserDao userDao = new UserDao(awsConnectionMaker);
        return userDao;
    }

    @Bean
    public UserDao localUserDao(){
        UserDao userDao = new UserDao(new LocalConnectionMaker());
        return userDao;
    }
}

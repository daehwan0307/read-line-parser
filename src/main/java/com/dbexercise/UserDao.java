package com.dbexercise;

import domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao {

    public User get(String id) throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv(); // 환경변수를 사용하여
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);

        /*DB에 쿼리 입력 후 바인딩*/
        PreparedStatement ps = conn.prepareStatement("SELECT id, name, password FROM users WHERE id = ?");
        ps.setString(1, id);

        /*쿼리 실행*/
        ResultSet resultSet = ps.executeQuery(); // ctrl + enter
        resultSet.next();

        User user = new User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("password"));

        ps.close(); // 서버 어플리케이션인 경우에는 반드시 작성 필요
        conn.close();

        return user;
    }

    //Dao : data access object
    public  void add(User user) throws SQLException,ClassNotFoundException {

        Map<String,String> env =System.getenv();

        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);

        PreparedStatement ps =conn.prepareStatement("INSERT  INTO  users(id,name,password) values (?,?,?)");

        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
    }
    public User findById(String id) throws SQLException, ClassNotFoundException {

        Map<String,String> env =System.getenv();

        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);

        //Query 문 작성
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users where id = ?");
        pstmt.setString(1,id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"),rs.getString("password"));
        //사용 종료 close.
        rs.close();
        pstmt.close();
        conn.close();

        return user;
    }

    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        UserDao userDao = new UserDao();
        userDao. add(new User("7","hwan","1234"));
     //   User testUser = userDao.get("2");
      //  System.out.println(testUser.getName());
    }


}

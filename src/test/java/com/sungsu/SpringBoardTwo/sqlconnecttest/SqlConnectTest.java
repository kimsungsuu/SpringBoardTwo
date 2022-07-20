package com.sungsu.SpringBoardTwo.sqlconnecttest;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * mysql이 정상적으로 연결 되는지 확인하는 Test
 * Class.forName : 드라이버 로드
 * getConnection : mysql 연결
 */

public class SqlConnectTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/user?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "pw1234";

    @Test
    public void testConnection() throws Exception{

        Class.forName(DRIVER);

        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

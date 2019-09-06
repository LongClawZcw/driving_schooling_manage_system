package com.zhangcw.driving_schooling_manage_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
    public static void main(String[]args)throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet res = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/driving_schooling_manage_system?serverTimezone=UTC";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,user,password);
            String sql = "select * from tb_coach where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,1l);
            res = preparedStatement.executeQuery();
            while(res.next()){
                System.out.println(res.getString("coach_name"));
                System.out.println(res.getInt("age"));
            }
        }finally {
            if(res !=null){
                res.close();
            }
            if(preparedStatement !=null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}

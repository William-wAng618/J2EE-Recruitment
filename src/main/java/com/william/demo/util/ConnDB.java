package com.william.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
    //数据库账号密码
    private static String username="root";
    private static String password="A123456@";
    private static String uri="jdbc:mysql://localhost:3306/employ?useUnicode=true&characterEncoding=utf-8";
    private static Connection conn;
    public static Connection getConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            conn=DriverManager.getConnection(uri,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args){
        //ConnDB.getConn();
        int sex=0;
        String s=sex==0?"男":"女";
        if(sex==0){
            s="男";
        }else{
            s="女";
        }
    }
}

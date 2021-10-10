/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Minh Khoa
 */
public class DBUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //String url = "jdbc:sqlserver://EventManagement.mssql.somee.com;dataBaseName=EventManagement";
        //conn = DriverManager.getConnection(url, "keru_SQLLogin_1", "nnrbbyiy7b");
        String url = "jdbc:sqlserver://localhost:1433;dataBaseName=EventManagement";
        conn = DriverManager.getConnection(url, "sa", "123456");
        return conn;
    }
}

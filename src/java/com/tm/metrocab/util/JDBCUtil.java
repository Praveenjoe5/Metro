package com.tm.metrocab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection connection = null;
       
        try {
            connection=DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app","app");
        } catch (SQLException se) {
            System.out.println(se);
        }
        return connection;
    }

    public static void closeConnection(Connection con) {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException se) {
                    System.out.println(se);
                }//catch
            }//if
        }//close
    }//method



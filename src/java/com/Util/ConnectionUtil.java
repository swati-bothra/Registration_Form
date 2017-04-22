package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {

    public static Connection getCon() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Project";
            con = DriverManager.getConnection(url, "root", "root");
            //con = DriverManager.getConnection(url, "root", "kuldeepsinh");

            if (con != null) {
                System.out.println("Database Connected");
            } else {
                System.out.println("Sorry!! database not connected");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        getCon();
    }
}

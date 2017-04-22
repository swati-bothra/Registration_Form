
package com.Dao;

import com.Bean.LoginBean;
import com.Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDao {

    Connection con = ConnectionUtil.getCon();
    Statement stmt = null;

    public LoginBean fetch(String uname, String pwd) {
        LoginBean bean = null;
        try {
            stmt = con.createStatement();
            String sel = "select * from login where username='" + uname + "' and password='" + pwd + "'";
            ResultSet rs = stmt.executeQuery(sel);
            while (rs.next()) {
                bean = new LoginBean();
                bean.setLogin_id(rs.getInt("login_id"));
                bean.setUname(rs.getString("username"));
                bean.setPwd(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bean;
    }

}

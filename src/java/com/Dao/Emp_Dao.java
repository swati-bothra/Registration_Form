
package com.Dao;

import com.Bean.Emp_Bean;
import com.Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Emp_Dao {

    Connection con = ConnectionUtil.getCon();
    Statement stmt = null;

    public int insertData(Emp_Bean bean) {
        int i = 0;
        try {
            stmt = con.createStatement();
            String insert = "insert into emp_reg(emp_fname,emp_lname,emp_email,emp_mob,emp_dob,emp_gender,"
                    + "emp_address,emp_city,emp_hobby) values('" + bean.getEmp_Fname() + "','" + bean.getEmp_Lname() + "','" +
                    bean.getEmp_Email() + "','" + bean.getEmp_Mob() + "','" + bean.getEmp_dob() + "','" + bean.getEmp_Gender() + 
                    "','" + bean.getEmp_Address() + "','" + bean.getEmp_City() + "','" + bean.getEmp_Hobby() + "')";
            System.out.println(insert);
            i = stmt.executeUpdate(insert);
        } catch (SQLException ex) {
            Logger.getLogger(Emp_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public List listData() {
        List<Emp_Bean> list = new ArrayList();
        try {
            stmt = con.createStatement();
            String sel = "select * from emp_reg";
            ResultSet rs = stmt.executeQuery(sel);
            while (rs.next()) {
                Emp_Bean bean = new Emp_Bean();
                bean.setEmp_id(rs.getInt("emp_id"));
                bean.setEmp_Fname(rs.getString("emp_fname"));
                bean.setEmp_Lname(rs.getString("emp_lname"));
                bean.setEmp_Email(rs.getString("emp_email"));
                bean.setEmp_Mob(rs.getString("emp_mob"));
                bean.setEmp_dob(rs.getString("emp_dob"));
                bean.setEmp_Gender(rs.getString("emp_gender"));
                bean.setEmp_Address(rs.getString("emp_address"));
                bean.setEmp_City(rs.getString("emp_city"));
                bean.setEmp_Hobby(rs.getString("emp_hobby"));
                list.add(bean);
            }
            
//           create table emp_reg (emp_id integer primary key auto_increment, emp_fname varchar(15), emp_lname varchar(15), emp_email varchar(25),
//          emp_mob varchar(15), emp_dob varchar(15), 
//           emp_gender varchar(15),emp_address varchar(35),emp_city varchar(25),emp_hobby varchar(15));
        } catch (SQLException ex) {
            Logger.getLogger(Emp_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int deleteData(int id) {
        int i = 0;
        try {
            stmt = con.createStatement();
            String del = "delete from emp_reg where emp_id=" + id + "";
//            System.out.println("mmmmmmmmmmmmmmm" + del);
            i = stmt.executeUpdate(del);
        } catch (SQLException ex) {
            Logger.getLogger(Emp_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public Emp_Bean fetchData(int id) {
        Emp_Bean bean = null;
        try {
            stmt = con.createStatement();
            String fetch = "select * from emp_reg where emp_id=" + id + "";
            ResultSet rs = stmt.executeQuery(fetch);
            while (rs.next()) {
                bean = new Emp_Bean();
                bean.setEmp_id(rs.getInt("emp_id"));
                bean.setEmp_Fname(rs.getString("emp_fname"));
                bean.setEmp_Lname(rs.getString("emp_lname"));
                bean.setEmp_Email(rs.getString("emp_email"));
                bean.setEmp_Mob(rs.getString("emp_mob"));
                bean.setEmp_dob(rs.getString("emp_dob"));
                bean.setEmp_Gender(rs.getString("emp_gender"));
                bean.setEmp_Address(rs.getString("emp_address"));
                bean.setEmp_City(rs.getString("emp_city"));
                bean.setEmp_Hobby(rs.getString("emp_hobby"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Emp_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bean;
    }

    public int updateData(Emp_Bean bean) {
        int i = 0;
        try {
            stmt = con.createStatement();
            String update = "update emp_reg set emp_fname='" + bean.getEmp_Fname() + "',emp_lname='" + bean.getEmp_Lname() + "',emp_email='" + bean.getEmp_Email() + "',emp_mob='" + bean.getEmp_Mob() + "',emp_dob='" + bean.getEmp_dob() + "',emp_gender='" + bean.getEmp_Gender() + "',emp_address='" + bean.getEmp_Address() + "',emp_city='" + bean.getEmp_City() + "',emp_hobby='" + bean.getEmp_Hobby() + "' where emp_id=" + bean.getEmp_id() + "";
            i = stmt.executeUpdate(update);
        } catch (SQLException ex) {
            Logger.getLogger(Emp_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}

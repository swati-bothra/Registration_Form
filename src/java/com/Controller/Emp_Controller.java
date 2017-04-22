
package com.Controller;

import com.Bean.Emp_Bean;
import com.Dao.Emp_Dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Emp_Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp_Bean bean = new Emp_Bean();
        Emp_Dao dao = new Emp_Dao();
        HttpSession session = req.getSession();
        String url = req.getRequestURI();

        if (url.contains("insert")) {
            String emp_fname = req.getParameter("txtEmpFname");
            String emp_lname = req.getParameter("txtEmpLname");
            String email = req.getParameter("txtEmail");
            String mob = req.getParameter("txtMob");
            String dob = req.getParameter("txtDob");
            String gender = req.getParameter("txtGender");
            String address = req.getParameter("txtAddress");
            String city = req.getParameter("selCity");
            String hby = ",";
            String[] hobby = req.getParameterValues("txtHobby");
            for (String hobby1 : hobby) {
                hby += hobby1 + ",";
            }

            bean.setEmp_Fname(emp_fname);
            bean.setEmp_Lname(emp_lname);
            bean.setEmp_Email(email);
            bean.setEmp_Mob(mob);
            bean.setEmp_dob(dob);
            bean.setEmp_Gender(gender);
            bean.setEmp_Address(address);
            bean.setEmp_City(city);
            bean.setEmp_Hobby(hby);

            int i = dao.insertData(bean);
            System.out.println(i);

            if (i >= 1) {
                session.setAttribute("Msg", "Data Inserted");
            } else {
                session.setAttribute("Msg", "Sorry !! data is not inserted");
            }
            resp.sendRedirect("/Swati_Bothra/Emp_Reg.jsp");

        } else if (url.contains("delete")) {
            int id = Integer.parseInt(req.getParameter("hidden"));
            int i = dao.deleteData(id);

//            System.out.println("iaaaaaaaaaaaaaaaaa" + i);
            if (i >= 1) {
                session.setAttribute("DMsg", "Data Deleted");
            } else {
                session.setAttribute("DMsg", "Sorry");
            }
            resp.sendRedirect("/Swati_Bothra/Emp_Reg.jsp");

        } else if (url.contains("fetch")) {
            int id = Integer.parseInt(req.getParameter("hidden"));
            Emp_Bean fetchbean = dao.fetchData(id);
            req.setAttribute("fetch", fetchbean);
            RequestDispatcher rd = req.getRequestDispatcher("/Emp_Reg.jsp");
            rd.forward(req, resp);

        } else if (url.contains("update")) {
            int id = Integer.parseInt(req.getParameter("hidden"));
            String emp_fname = req.getParameter("txtEmpFname");
            String emp_lname = req.getParameter("txtEmpLname");
            String email = req.getParameter("txtEmail");
            String mob = req.getParameter("txtMob");
            String dob = req.getParameter("txtDob");
            String gender = req.getParameter("txtGender");
            String address = req.getParameter("txtAddress");
            String city = req.getParameter("selCity");
            String hby = ",";
            String[] hobby = req.getParameterValues("txtHobby");
            for (String hobby1 : hobby) {
                hby += hobby1 + ",";
            }
            bean.setEmp_id(id);
            bean.setEmp_Fname(emp_fname);
            bean.setEmp_Lname(emp_lname);
            bean.setEmp_Email(email);
            bean.setEmp_Mob(mob);
            bean.setEmp_dob(dob);
            bean.setEmp_Gender(gender);
            bean.setEmp_Address(address);
            bean.setEmp_City(city);
            bean.setEmp_Hobby(hby);

            int i = dao.updateData(bean);
            if (i >= 1) {
                session.setAttribute("UpMsg", "Data Updated");
            } else {
                session.setAttribute("UpMsg", "Sorry");
            }
            resp.sendRedirect("/Swati_Bothra/Emp_Reg.jsp");
        }

    }
}

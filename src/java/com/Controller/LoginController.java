
package com.Controller;

import com.Bean.LoginBean;
import com.Dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("txtUsername");
        String pwd = req.getParameter("txtPwd");

        HttpSession session = req.getSession();
        LoginDao dao = new LoginDao();
        LoginBean bean = dao.fetch(uname, pwd);

        if (bean == null) {
            resp.sendRedirect("/Swati_Bothra/Login.jsp");
        } else {
            session.setAttribute("user_id", bean.getLogin_id());
            session.setAttribute("user_name", uname);
            session.setAttribute("pwd", pwd);
            resp.sendRedirect("/Swati_Bothra/Emp_Reg.jsp");
        }
    }
}

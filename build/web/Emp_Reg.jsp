<%-- 
    Author     : Swati Bothra
    Created on : 20-4-2017 
--%>

<%@page import="com.Bean.Emp_Bean"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.Emp_Dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        if (session.getAttribute("pwd") == null) {
            response.sendRedirect("/Swati_Bothra/Login.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="jquery/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="jquery/preview.css" rel="stylesheet" type="text/css"/>
        <style>
            #empfrm label.error{
                color: red;
                font-family: cursive
            }
        </style>
    </head>
    <body>
        <%            Emp_Bean fetchbean = (Emp_Bean) request.getAttribute("fetch");
            if (fetchbean == null) {

        %>  
        <form method="post" action="Emp_Controller/insert" id="empfrm">
            <%                if (session.getAttribute("Msg") != null) {
                    out.println(session.getAttribute("Msg"));
                    session.removeAttribute("Msg");
                }

            %>
            <center>
                <table border="2">
                    <tr>
                        <td>Emp_Fname</td>
                        <td><input type="text" id="txtEmpFname" name="txtEmpFname" placeholder="Enter EmpFname"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Lname</td>
                        <td><input type="text" id="txtEmpLname" name="txtEmpLname" placeholder="Enter EmpLname"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Email</td>
                        <td><input type="email" id="txtEmail" name="txtEmail" placeholder="Enter Emp_Id"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Mob</td>
                        <td><input type="number" id="txtMob" name="txtMob" placeholder="Enter MobileNo"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Dob</td>
                        <td><input type="date" id="txtDob" name="txtDob"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Gender</td>
                        <td> <label id="txtGender"><input type="radio" name="txtGender" value="Male"/>Male
                                <input type="radio" name="txtGender" value="FeMale"/>FeMale</label>
                        </td>
                    </tr>

                    <tr>
                        <td>Emp_Address</td>
                        <td><textarea id="txtAddress" name="txtAddress" style="resize: none" placeholder="Enter Address"></textarea></td>
                    </tr>
                    <tr>
                        <td>Emp_City</td>
                        <td><label id="selCity">
                                <select name="selCity" id="selCity">
                                    <option>Baroda</option>
                                    <option>Surat</option>
                                    <option>A.bad</option>
                                </select></label></td>
                    </tr>
                    <tr>
                        <td>Emp_Hobby</td>
                        <td>
                            <label id="txtHobby">
                                <input type="checkbox" name="txtHobby" value="Cricket"/>Cricket
                                <input type="checkbox" name="txtHobby" value="Music"/>Music
                                <input type="checkbox" name="txtHobby" value="Reading"/>Reading </label> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="clickMe"/>
                        </td>
                    </tr>
                </table>
            </center>
        </form>
        <% } else {%>
        <br>
        <form method="post" action="Emp_Controller/update">
            <%
                if (session.getAttribute("UpMsg") != null) {
                    out.println(session.getAttribute("UpMsg"));
                    session.removeAttribute("UpMsg");
                }
            %>
            <center>
                <table style="border: 1px solid black">
                    <input type="text" name="hidden" id="hidden" value="<%=fetchbean.getEmp_id()%>"/>
                    <tr>
                        <td>Emp_Fname</td>
                        <td><input type="text" name="txtEmpFname" placeholder="Enter EmpFname" value="<%=fetchbean.getEmp_Fname()%>"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Lname</td>
                        <td><input type="text" name="txtEmpLname" placeholder="Enter EmpLname" value="<%=fetchbean.getEmp_Lname()%>"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Email</td>
                        <td><input type="email" name="txtEmail" placeholder="Enter Emp_Id" value="<%=fetchbean.getEmp_Email()%>"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Mob</td>
                        <td><input type="number" name="txtMob" placeholder="Enter MobileNo" value="<%=fetchbean.getEmp_Mob()%>"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Dob</td>
                        <td><input type="date" name="txtDob" value="<%=fetchbean.getEmp_dob()%>"/></td>
                    </tr>
                    <tr>
                        <td>Emp_Gender</td>
                        <td>
                            <input type="radio" name="txtGender" value="Male"/>Male
                            <input type="radio" name="txtGender" value="FeMale"/>FeMale
                        </td>
                    </tr>

                    <tr>
                        <td>Emp_Address</td>
                        <td><textarea name="txtAddress" style="resize: none" placeholder="Enter Address"><%=fetchbean.getEmp_Address()%></textarea></td>
                    </tr>
                    <tr>
                        <td>Emp_City</td>
                        <td>
                            <select name="selCity">
                                <option value="<%=fetchbean.getEmp_City()%>">Baroda</option>
                                <option value="<%=fetchbean.getEmp_City()%>">Surat</option>
                                <option value="<%=fetchbean.getEmp_City()%>">A.bad</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Emp_Hobby</td>
                        <td><input type="checkbox" name="txtHobby" value="Cricket"/>Cricket
                            <input type="checkbox" name="txtHobby" value="Music"/>Music
                            <input type="checkbox" name="txtHobby" value="Reading"/>Reading</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="clickMe"/>
                        </td>
                    </tr>
                </table>
            </center>
        </form>
        <% }%>

        <br>
        <form name="regfrm">
            <input type="hidden" name="hidden" id="hidden"/>
            <table border="1">
                <thead>
                <th>Emp_Id</th>
                <th>Emp_Fname</th>
                <th>Emp_Lname</th>
                <th>Emp_Email</th>
                <th>Emp_Mobile</th>
                <th>Emp_Dob</th>
                <th>Emp_Gemder</th>
                <th>Emp_Address</th>
                <th>Emp_City</th>
                <th>Emp_Hobby</th>
                <th>Action</th>
                </thead>
                <tbody>
                    <%  Emp_Dao dao = new Emp_Dao();
                        List<Emp_Bean> listData = dao.listData();
                        for (Emp_Bean bean : listData) {


                    %>

                    <%                        if (session.getAttribute("DMsg") != null) {
                            out.println(session.getAttribute("DMsg"));
                            session.removeAttribute("DMsg");
                        }
                    %>
                    <tr>
                        <td><%=bean.getEmp_id()%></td>
                        <td><%=bean.getEmp_Fname()%></td>
                        <td><%=bean.getEmp_Lname()%></td>
                        <td><%=bean.getEmp_Email()%></td>
                        <td><%=bean.getEmp_Mob()%></td>
                        <td><%=bean.getEmp_dob()%></td>
                        <td><%=bean.getEmp_Gender()%></td>
                        <td><%=bean.getEmp_Address()%></td>
                        <td><%=bean.getEmp_City()%></td>
                        <td><%=bean.getEmp_Hobby()%></td>

                        <td>
                            <input type="button" value="Delete" onclick="deleteReg(<%=bean.getEmp_id()%>)"/>
                            <input type="button" value="Update" onclick="fetchReg(<%=bean.getEmp_id()%>)"/>
                        </td>

                    </tr>
                    <% }%>
                </tbody>
            </table>
        </form>
        <script>
            function deleteReg(id) {
//                alert(id)
                document.getElementById('hidden').value = id;
                document.regfrm.method = "post";
                document.regfrm.action = "Emp_Controller/delete";
                document.regfrm.submit();
            }

            function fetchReg(id) {
                document.getElementById('hidden').value = id;
                document.regfrm.method = "post";
                document.regfrm.action = "Emp_Controller/fetch";
                document.regfrm.submit();
            }
        </script>
        <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="js/jquery-1.9.1.js" type="text/javascript"></script>    
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="js/jquery.validate.js" type="text/javascript"></script>
        <script src="validation/Emp_Reg.js" type="text/javascript"></script>
    </body>
</html>

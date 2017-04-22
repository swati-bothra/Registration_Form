<%-- 
   Author     : Swati Bothra
   Created on : 20-4-2017
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="jquery/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="jquery/preview.css" rel="stylesheet" type="text/css"/>
        <style>
            #loginfrm label.error{
                color: red;
                font-family:cursive
            }
            
        </style>
    </head>
    <body>
        <form method="post" action="LoginController" id="loginfrm">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" id="txtUsername" name="txtUsername" placeholder="Username"/></td>
                </tr>
                <tr>
                    <td>Pwd:</td>
                    <td><input type="password" id="txtPwd" name="txtPwd" placeholder="Pwd"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="login"/></td>
                </tr>
            </table>
        </form>      
        <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="js/jquery-1.9.1.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="jquery/jquery.validate.js" type="text/javascript"></script>
        <script src="validation/LoginValidation.js" type="text/javascript"></script>
    </body>
</html>

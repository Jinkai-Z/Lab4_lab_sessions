<%-- 
    Document   : login
    Created on : 14-Oct-2020, 7:29:11 PM
    Author     : 782290
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
           <h1>Login</h1>
           <div>${error_msg}</div>
           <form action="LoginServlet" method="POST">
               <label>username:</label><input type="text" name="username">
               <br>
               <label>password</label><input type="password" name="password">
               <br>
               <input type="submit" value="Login">
           </form>
    </body>
</html>

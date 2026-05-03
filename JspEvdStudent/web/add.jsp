<%-- 
    Document   : add
    Created on : May 3, 2026, 10:44:17 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Student</h1>
        
        <form action="StudentServlet" method="post">
            <input type="hidden" name="action" value="add"/>

    <label for="">Name</label>
    <input type="text" name="name"><br>

    <label for="">Clas</label>
    <input type="text" name="clas"><br>

    <label for="">Role</label>
    <input type="text" name="role"><br>

    <input type="submit" value="save">

   </form>
    </body>
</html>

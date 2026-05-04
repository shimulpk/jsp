<%-- 
    Document   : add
    Created on : May 4, 2026, 9:48:58 AM
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
        <h1>Add Employee</h1>
        <form action="EmployeeServlet" method="post">
            <input type="hidden" name="action" value="add"/>

    <label for="">Name</label>
    <input type="text" name="name"><br>

    <label for="">Designation</label>
    <input type="text" name="designation"><br>

    <label for="">Salary</label>
    <input type="text" name="salary"><br>
    
    <label for="">Hire Date</label>
    <input type="text" name="hire_date"><br>
    
    <label for="">Department</label>
    <input type="text" name="department"><br>

    <input type="submit" value="save">

   </form>
    </body>
</html>

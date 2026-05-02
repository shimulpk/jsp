<%-- 
    Document   : add
    Created on : May 3, 2026, 12:02:36 AM
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
        <h1>Hello World!</h1>
        <h2>Add Teacher</h2>

<form action="TeacherServlet" method="post">

    <!-- action identify  -->
    <input type="hidden" name="action" value="insert"/>

    Name: <input type="text" name="name" required><br><br>

    Salary: <input type="number" step="0.01" name="salary" required><br><br>

    Designation: <input type="text" name="designation" required><br><br>

    <input type="submit" value="Save">

</form>

<br>
<a href="TeacherServlet">Back to List</a>
    </body>
</html>

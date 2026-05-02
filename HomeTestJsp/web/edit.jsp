
<%@ page import="entity.Teacher" %>

<%
Teacher t = (Teacher) request.getAttribute("teacher");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Edit Teacher</h1>
        <form action="TeacherServlet" method="post">

    <!-- 🔴 VERY IMPORTANT -->
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="<%=t.getId()%>"/>

    Name: 
    <input type="text" name="name" value="<%=t.getName()%>" required><br><br>

    Salary: 
    <input type="number" step="0.01" name="salary" value="<%=t.getSalary()%>" required><br><br>

    Designation: 
    <input type="text" name="designation" value="<%=t.getDesignation()%>" required><br><br>

    <input type="submit" value="Update">

</form>

<br>
<a href="TeacherServlet">Back to List</a>
    </body>
</html>

<%-- 
    Document   : edit
    Created on : May 4, 2026, 9:53:51 AM
    Author     : hp
--%>
<%@page import="entity.Employee" %>

<% 
Employee e= (Employee)request.getAttribute("employee");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Employee</h1>
        
        <form action="EmployeeServlet" method="post">
            <input type="hidden" name="action" value="add"/>
            <input type="hidden" name="id" value="<%=e.getId()%>"/>

    <label for="">Name</label>
    <input type="text" name="name" value="<%=e.getName()%>"><br>

    <label for="">Designation</label>
    <input type="text" name="designation" value="<%=e.getDesignation()%>"><br>

    <label for="">Salary</label>
    <input type="text" name="salary" value="<%=e.getSalary()%>"><br>
    
    
    <label for="">Hire Date</label>
    <input type="text" name="hire_date" value="<%=e.getHire_date()%>"><br>
    
    
    <label for=""> Department</label>
    <input type="text" name="department" value="<%=e.getDepartment()%>"><br>

    <input type="submit" value="update">

   </form>
    </body>
</html>

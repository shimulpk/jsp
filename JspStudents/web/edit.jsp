<%-- 
    Document   : edit
    Created on : May 4, 2026, 11:42:41 AM
    Author     : hp
--%>
<%@page import="entity.Students" %>

<% 
Students s= (Students)request.getAttribute("student");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Students</h1>
        <form action="StudentsServlet" method="post">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<%=s.getId()%>"/>

    <label for="">Name</label>
    <input type="text" name="name" value="<%=s.getName()%>"><br>

    <label for="">Email</label>
    <input type="email" name="email" value="<%=s.getEmail()%>"><br>

    <label for="">Date of birth</label>
    <input type="date" name="dob" value="<%=s.getDob()%>"><br>
    
    <label for="">Fee</label>
    <input type="number" name="fee" value="<%=s.getFee()%>"><br>
    
    <label for="">Department</label>
    <input type="text" name="department" value="<%=s.getDepartment()%>"><br>

    <input type="submit" value="update">
    </body>
</html>

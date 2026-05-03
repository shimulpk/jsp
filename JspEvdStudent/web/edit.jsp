<%-- 
    Document   : edit
    Created on : May 4, 2026, 12:59:36 AM
    Author     : hp
--%>
<%@page import="entity.Student" %>

<% 
Student s= (Student)request.getAttribute("student");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="StudentServlet" method="post">
            <input type="hidden" name="action" value="add"/>
            <input type="hidden" name="id" value="<%=s.getId()%>"/>

    <label for="">Name</label>
    <input type="text" name="name" value="<%=s.getName()%>"><br>

    <label for="">Clas</label>
    <input type="text" name="clas" value="<%=s.getClas()%>"><br>

    <label for="">Role</label>
    <input type="text" name="role" value="<%=s.getRole()%>"><br>

    <input type="submit" value="save">

   </form>
    </body>
</html>

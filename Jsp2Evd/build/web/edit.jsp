<%-- 
    Document   : edit
    Created on : Apr 30, 2026, 11:12:45 AM
    Author     : hp
--%>
<%@page import="entity.Student2" %>

<% 
Student2 s=(Student2)request.getAttribute("student2");
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
         <form action="student" method="POST">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" value="<%=s.getId()%>" name="id"/>
   <label for="">Name</label>
   <input type="text" name="name" value="<%=s.getName()%>"> <br>


   <label for="">Email</label>
   <input type="email" name="email" value="<%=s.getEmail()%>"> <br>


   <label for="">Date of Birth</label>
   <input type="date" name="dob" value="<%=s.getDob()%>"> <br>


   <label for="">Fee</label>
   <input type="text" name="fee" value="<%=s.getFee()%>"> <br>

   <input type="submit" value="update">
   </form>
    </body>
</html>

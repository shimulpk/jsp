<%@page import="entity.Emp3" %>

<% 
Emp3 e=(Emp3) request.getAttribute("emp3");
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
        
        <form action="empServelet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%=e.getId() %>">
            

    <label for="">Name</label>
    <input type="text" name="name" value="<%=e.getName() %>">

    <label for="">Email</label>
    <input type="text" name="email" value="<%=e.getEmail() %>">
    
    <input type="submit" value="update">

   </form>
    </body>
</html>

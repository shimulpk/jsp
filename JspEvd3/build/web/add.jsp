<%-- 
    Document   : add
    Created on : May 2, 2026, 12:22:47 PM
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
       
        <h1>Add Emp</h1>
        
        <form action="empServelet" method="post">
            <input type="hidden" name="action" value="add">

    <label for="">Name</label>
    <input type="text" name="name">

    <label for="">Email</label>
    <input type="text" name="email">
    
    <input type="submit" value="save">

   </form>
    </body>
</html>

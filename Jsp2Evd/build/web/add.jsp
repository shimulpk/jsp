<%-- 
    Document   : add
    Created on : Apr 29, 2026, 9:54:13 PM
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
        <<h1>Add Student</h1>
        <form action="student" method="POST">
            <input type="hidden" name="action" value="add"/>
   <label for="">Name</label>
   <input type="text" name="name"> <br>


   <label for="">Email</label>
   <input type="email" name="email"> <br>


   <label for="">Date of Birth</label>
   <input type="date" name="dob"> <br>


   <label for="">Fee</label>
   <input type="text" name="fee"> <br>

   <input type="submit" value="save">
   </form>
    </body>
</html>

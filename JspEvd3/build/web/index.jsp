<%@page import="entity.Emp3" %>
<%@page import="dao.Emp3Dao" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
List<Emp3> list=Emp3Dao.getAll();
request.setAttribute("list",list);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <a href="add.jsp"> Add Emp</a>
        <h1>All Emp3</h1>
        <table border="1">
    <thead>
        <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="s">
            
             <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>${s.email}</td>
        <td>
            <a href="empServelet? action=edit&id=${s.id}">Edit</a>
            <a href="empServelet? action=delete&id=${s.id}">Delete</a>
        </td>
    </tr>
        </c:forEach>
    </tbody>
   </table>
    </body>
</html>

<%@page import="entity.Student2" %>
<%@page import="dao.Student2Dao "%>
<%@page import="java.util.* "%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
List<Student2> list=Student2Dao.getAll();
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
        <a href="add.jsp"> Add Student</a>
        <<h1>All Student</h1>
        <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Dob</th>
                <th>Fee</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="s">
                
                <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.dob}</td>
                <td>${s.fee}</td>
                
                <td>
                    <a href="student?action=edit&id=${s.id}">Edit</a>
                    <a href="student?action=delete&id=${s.id}">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>

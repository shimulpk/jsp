<%@page import="entity.Student" %>
<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
List<Student> list=StudentDao.getAll();
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
        <a href="add.jsp">Add Student</a>
        <h1>All Student</h1>
        <table border="1">
    <thead>
        <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Clas</th>
        <th>Role</th>
        <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="s">
            <tr>    
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>${s.clas}</td>
      <td>${s.role}</td>
      <td>
          <a href="StudentServlet?action=edit&id=${s.id}">Edit</a>
          <a href="StudentServlet?action=delete&id=${s.id}">Delete</a>
      </td>
            </tr>
            
        </c:forEach>
    </tbody>
   </table>
        
    </body>
</html>

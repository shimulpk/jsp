<%@page import="entity.Students" %>
<%@page import="dao.StudentsDao" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
List<Students> list=StudentsDao.getAll();
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
        <h1>All Students</h1>
        <table border="1">
    <thead>
        <tr>
<!--             <th>Id</th>-->
        <th>Roll</th>
        <th>Name</th>
        <th>Subjects</th>
        <th>Marks</th>
        <th>Departments</th>
       
        <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="s">
            <tr>    
<!--      <td>${s.id}</td>-->
      <td>${s.name}</td>
      <td>${s.email}</td>
      <td>${s.dob}</td>
      <td>${s.fee}</td>
      <td>${s.department}</td>
      <td>
          <a href="StudentsServlet?action=edit&id=${s.id}">Edit</a>
          <a href="StudentsServlet?action=delete&id=${s.id}">Delete</a>
      </td>
            </tr>
            
        </c:forEach>
    </tbody>
   </table>
    </body>
</html>

<%@page import="entity.Employee" %>
<%@page import="dao.EmployeeDao" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
List<Employee> list=EmployeeDao.getAll();
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
       <a href="add.jsp">Add Employee</a>
        <h1>All Employee</h1>
        <table border="1">
    <thead>
        <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Designation</th>
        <th>Salary</th>
        <th>Hire Date</th>
        <th>Department</th>
        <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="e">
            <tr>    
      <td>${e.id}</td>
      <td>${e.name}</td>
      <td>${e.designation}</td>
      <td>${e.salary}</td>
      <td>${e.hire_date}</td>
      <td>${e.department}</td>
      <td>
          <a href="EmployeeServlet?action=edit&id=${e.id}">Edit</a>
          <a href="EmployeeServlet?action=delete&id=${e.id}">Delete</a>
      </td>
            </tr>
            
        </c:forEach>
    </tbody>
   </table>
    </body>
</html>

<%@ page import="java.util.*, entity.Teacher" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Teacher</h1>
        <a href="add.jsp">Add Teacher</a>
        <table border="1">
<tr>
<th>ID</th><th>Name</th><th>Salary</th><th>Designation</th><th>Action</th>
</tr>

<%
List<Teacher> list = (List<Teacher>) request.getAttribute("list");
if(list != null){
for(Teacher t : list){
%>

<tr>
<td><%=t.getId()%></td>
<td><%=t.getName()%></td>
<td><%=t.getSalary()%></td>
<td><%=t.getDesignation()%></td>
<td>
<a href="TeacherServlet?action=edit&id=<%=t.getId()%>">Edit</a>
<a href="TeacherServlet?action=delete&id=<%=t.getId()%>">Delete</a>
</td>
</tr>

<% }} %>
</table>
    </body>
</html>

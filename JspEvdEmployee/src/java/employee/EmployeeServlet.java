/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package employee;

import dao.EmployeeDao;
import entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author hp
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

    EmployeeDao dao=new EmployeeDao();
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        if("delete".equalsIgnoreCase(action)){
        int id=(Integer.parseInt(request.getParameter("id")));
        dao.delete(id);
        response.sendRedirect("home.jsp");
            
        }
        
        else if("edit".equalsIgnoreCase(action)){
        int id=(Integer.parseInt(request.getParameter("id")));
            Employee e=dao.getById(id);
            request.setAttribute("employee", e);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String action=request.getParameter("action");
        
        if("add".equalsIgnoreCase(action)){
            Employee e=new Employee();
            e.setName(request.getParameter("name"));
            e.setDesignation(request.getParameter("designation"));
            e.setSalary(request.getParameter("salary"));
            e.setHire_date(request.getParameter("hire_date"));
            e.setDepartment(request.getParameter("department"));
            
            dao.save(e);
            response.sendRedirect("home.jsp");
        }
        
        else if("update".equalsIgnoreCase(action)){
        Employee e=new Employee();
            e.setName(request.getParameter("name"));
            e.setDesignation(request.getParameter("designation"));
            e.setSalary(request.getParameter("salary"));
            e.setHire_date(request.getParameter("hire_date"));
            e.setDepartment(request.getParameter("department"));
            e.setId(Integer.parseInt(request.getParameter("id")));
            
          dao.update(e);
            response.sendRedirect("home.jsp");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

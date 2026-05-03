/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.StudentDao;
import entity.Student;
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
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    StudentDao dao=new StudentDao();
    

    
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
            Student s=dao.getById(id);
            request.setAttribute("student", s);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action=request.getParameter("action");
        
        if("add".equalsIgnoreCase(action)){
            Student s=new Student();
            s.setName(request.getParameter("name"));
            s.setClas(request.getParameter("clas"));
            s.setRole(request.getParameter("role"));
            
            dao.save(s);
            response.sendRedirect("home.jsp");
        }
        
        else if("update".equalsIgnoreCase(action)){
        Student s=new Student();
            s.setName(request.getParameter("name"));
            s.setClas(request.getParameter("clas"));
            s.setRole(request.getParameter("role"));
            s.setId(Integer.parseInt(request.getParameter("id")));
            
          dao.update(s);
            response.sendRedirect("home.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

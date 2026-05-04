/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.StudentsDao;
import entity.Students;
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
@WebServlet(name = "StudentsServlet", urlPatterns = {"/StudentsServlet"})
public class StudentsServlet extends HttpServlet {

    StudentsDao dao=new StudentsDao();

    
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
            Students s=dao.getById(id);
            request.setAttribute("student", s);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        
        if("add".equalsIgnoreCase(action)){
            Students s=new Students();
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setDob(request.getParameter("dob"));
            s.setFee(request.getParameter("fee"));
            s.setDepartment(request.getParameter("department"));
            
            dao.save(s);
            response.sendRedirect("home.jsp");
        }
        
        else if("update".equalsIgnoreCase(action)){
        Students s=new Students();
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setDob(request.getParameter("dob"));
            s.setFee(request.getParameter("fee"));
            s.setDepartment(request.getParameter("department"));
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

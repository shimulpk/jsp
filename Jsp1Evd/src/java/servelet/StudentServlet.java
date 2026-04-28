/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

import dao.Student1Dao;
import entity.Student1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @author Admin
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/servlet"})
public class StudentServlet extends HttpServlet {

    
    Student1Dao dao=new Student1Dao();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
         if("delete".equalsIgnoreCase(action)){
         int id=Integer.getInteger(request.getParameter("id"));
         dao.delete(id);
         response.sendRedirect("home.jsp");
         }
        
         else if("edit".equalsIgnoreCase(action)){
         int id=Integer.getInteger(request.getParameter("id"));
         Student1 s=dao.getById(id);
         }
         
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        
        if("add".equalsIgnoreCase(action)){
            Student1 s=new Student1();
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setDob(request.getParameter("dob"));
            s.setFee(Double.parseDouble(request.getParameter("fee")));
            
            
            dao.save(s);
            response.sendRedirect("home.jsp");
            
        }
        
        else if("update".equalsIgnoreCase(action)){
        Student1 s=new Student1();
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setDob(request.getParameter("dob"));
            s.setFee(Double.parseDouble(request.getParameter("fee")));
            s.setId(Integer.getInteger(request.getParameter("id")));
            dao.update(s);
             response.sendRedirect("home.jsp");
        
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

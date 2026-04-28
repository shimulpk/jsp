/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

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
@WebServlet(name = "StudentServelet", urlPatterns = {"/student"})
public class StudentServelet extends HttpServlet {

    StudentDao dao=new StudentDao();
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        
        if("add".equalsIgnoreCase(action)){
            Student s=new Student();
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setDob(request.getParameter("dob"));
            s.setFee(Double.parseDouble(request.getParameter("fee")));
           
            dao.save(s);
            response.sendRedirect("home.jsp");
          
        }
        
        else if(){}
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

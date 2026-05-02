/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servelet;

import jakarta.servlet.annotation.WebServlet;

import dao.TeacherDao;
import entity.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class TeacherServelet {
    
    
    





@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {

    private TeacherDao dao;

    @Override
    public void init() {
        dao = new TeacherDao();
    }

    // 🔥 GET (list, delete, edit)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            // 👉 default = list
            if (action == null || action.equals("list")) {

                List<Teacher> list = dao.getAllTeachers();
                request.setAttribute("list", list);
                request.getRequestDispatcher("home.jsp").forward(request, response);

            }
            // 👉 delete
            else if (action.equals("delete")) {

                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteTeacher(id);
                response.sendRedirect("TeacherServlet");

            }
            // 👉 edit
            else if (action.equals("edit")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Teacher t = dao.getTeacherById(id);

                request.setAttribute("teacher", t);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 POST (insert, update)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            // 👉 insert
            if (action.equals("insert")) {

                Teacher t = new Teacher(
                        0,
                        request.getParameter("name"),
                        Double.parseDouble(request.getParameter("salary")),
                        request.getParameter("designation")
                );

                dao.insertTeacher(t);
            }

            // 👉 update
            else if (action.equals("update")) {

                Teacher t = new Teacher(
                        Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        Double.parseDouble(request.getParameter("salary")),
                        request.getParameter("designation")
                );

                dao.updateTeacher(t);
            }

            response.sendRedirect("TeacherServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
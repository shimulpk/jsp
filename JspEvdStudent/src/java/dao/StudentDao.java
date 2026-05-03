/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DbUtil;

/**
 *
 * @author hp
 */
public class StudentDao {
   static DbUtil util=new DbUtil();
   static PreparedStatement ps;
   static ResultSet rs;
   static String sql;
   
   public  void save(Student s){
       
   sql="insert into student(name,clas,role) values(?,?,?)";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, s.getName());
           ps.setString(2, s.getClas());
           ps.setString(3, s.getRole());
           
           
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public static List<Student> getAll(){
   List<Student> list=new ArrayList<>();
   sql="select * from student";
   
       try {
           ps=util.getCon().prepareStatement(sql);
           
           rs=ps.executeQuery();
           while(rs.next()){
           Student s=new Student(rs.getInt("id"),
                   rs.getString("name"), 
                   rs.getString("clas"), 
                   rs.getString("role")
           );
           list.add(s);
           }
           
           ps.close();
           rs.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   return list;
   }
   
   public void delete(int id){
   sql="delete from student where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void update(Student s){
       
   sql="update student set name=?,clas=?,role=? where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, s.getName());
           ps.setString(2, s.getClas());
           ps.setString(3, s.getRole());
           ps.setInt(4, s.getId());
           
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public Student getById(int id){
       Student s=null;
   sql="select * from student where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           rs=ps.executeQuery();
           
           while(rs.next()){
            s=new Student(rs.getInt("id"),
                   rs.getString("name"), 
                   rs.getString("clas"), 
                   rs.getString("role")
           );
           
           }
       } catch (SQLException ex) {
           Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return s;
   }
}

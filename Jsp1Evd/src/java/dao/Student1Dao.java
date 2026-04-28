/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Student1;
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
 * @author Admin
 */
public class Student1Dao {
    
   static DbUtil util=new DbUtil();
   static PreparedStatement ps;
   static ResultSet rs;
   static String sql;
   
   public  void save(Student1 s){
       int status=0;
   
       sql="insert into student1(name,email,dob,fee) values(?,?,?,?)";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, s.getName());
           ps.setString(2, s.getEmail());
           ps.setString(3, s.getDob());
           ps.setDouble(4, s.getFee());
           
           status=ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(Student1Dao.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public static List<Student1>getAll(){
   
   List<Student1> list=new ArrayList<>();
   
   sql="select * from student";
       try {
           ps=util.getCon().prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
           Student1 s=new Student1(rs.getInt("id"),
                   rs.getString("name"), 
                   rs.getString("email"),
                   rs.getString("dob"),
                   rs.getDouble("fee"));
           
           list.add(s);
           
           }
       } catch (SQLException ex) {
           Logger.getLogger(Student1Dao.class.getName()).log(Level.SEVERE, null, ex);
       }
   return list;
   }
   
   public void delete(int id){
   sql="delete from student1 where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
       } catch (SQLException ex) {
           Logger.getLogger(Student1Dao.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   
   public void update(Student1 s){
   sql="update student1 set name=?,email=?,dob=?,fee=? where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, s.getName());
           ps.setString(2, s.getEmail());
           ps.setString(3, s.getDob());
           ps.setDouble(4, s.getFee());
           ps.setInt(4, s.getId());
           
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
          
       } catch (SQLException ex) {
           Logger.getLogger(Student1Dao.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   
   
   }
   
   public Student1 getById(int id){
    Student1 s=null;
    sql="select * from student where id=?";
        try {
            ps=util.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
             s=new Student1(rs.getInt("id"),
                    rs.getString("name"), 
                    rs.getString("email"), 
                    rs.getString("dob"),
                    rs.getDouble("fee"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student1Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return s;
    }
   }
    


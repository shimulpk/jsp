/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Students;
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
public class StudentsDao {
    
    static DbUtil util=new DbUtil();
   static PreparedStatement ps;
   static ResultSet rs;
   static String sql;
   
   public  void save(Students s){
       
   sql="insert into students(name,email,dob,fee,department) values(?,?,?,?,?)";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, s.getName());
           ps.setString(2, s.getEmail());
           ps.setString(3, s.getDob());
           ps.setString(4, s.getFee());
           ps.setString(5, s.getDepartment());
           
           
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public static List<Students> getAll(){
   List<Students> list=new ArrayList<>();
   sql="select * from students";
   
       try {
           ps=util.getCon().prepareStatement(sql);
           
           rs=ps.executeQuery();
           while(rs.next()){
           Students s=new Students(rs.getInt("id"),
                   rs.getString("name"), 
                   rs.getString("email"), 
                   rs.getString("dob"),
                   rs.getString("fee"),
                   rs.getString("department")
           );
           list.add(s);
           }
           
           ps.close();
           rs.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   return list;
   }
   
   public void delete(int id){
   sql="delete from students where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void update(Students s){
       
   sql="update students set name=?,email=?,dob=?,fee=?,department=? where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, s.getName());
           ps.setString(2, s.getEmail());
           ps.setString(3, s.getDob());
           ps.setString(4, s.getFee());
           ps.setString(5, s.getDepartment());
           ps.setInt(6, s.getId());
           
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public Students getById(int id){
       Students s=null;
   sql="select * from students where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           rs=ps.executeQuery();
           
           while(rs.next()){
            s=new Students(rs.getInt("id"),
                   rs.getString("name"), 
                   rs.getString("email"), 
                   rs.getString("dob"),
                   rs.getString("fee"),
                   rs.getString("department")
                   
           );
           
           }
       } catch (SQLException ex) {
           Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return s;
   }
    
}

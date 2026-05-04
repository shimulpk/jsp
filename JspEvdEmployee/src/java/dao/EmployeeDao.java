/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Employee;
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
public class EmployeeDao {
    
    static DbUtil util=new DbUtil();
   static PreparedStatement ps;
   static ResultSet rs;
   static String sql;
   
   public  void save(Employee e){
       
   sql="insert into employee(name,designation,salary,hire_date,department) values(?,?,?,?,?)";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, e.getName());
           ps.setString(2, e.getDesignation());
           ps.setString(3, e.getSalary());
           ps.setString(4, e.getHire_date());
           ps.setString(5, e.getDepartment());
           
           
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public static List<Employee> getAll(){
   List<Employee> list=new ArrayList<>();
   sql="select * from employee";
   
       try {
           ps=util.getCon().prepareStatement(sql);
           
           rs=ps.executeQuery();
           while(rs.next()){
           Employee e=new Employee(rs.getInt("id"),
                   rs.getString("name"), 
                   rs.getString("designation"), 
                   rs.getString("salary"),
                   rs.getString("hire_date"),
                   rs.getString("department")
                  
           );
           list.add(e);
           }
           
           ps.close();
           rs.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   return list;
   }
   
   public void delete(int id){
   sql="delete from employee where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void update(Employee e){
       
   sql="update employee set name=?,designation=?,salary=?,hire_date=?,department=? where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setString(1, e.getName());
           ps.setString(2, e.getDesignation());
           ps.setString(3, e.getSalary());
           ps.setString(4, e.getHire_date());
           ps.setString(5, e.getDepartment());
           ps.setInt(6, e.getId());
           
           
           
           ps.executeUpdate();
           ps.close();
           util.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public Employee getById(int id){
       Employee e=null;
   sql="select * from employee where id=?";
       try {
           ps=util.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           rs=ps.executeQuery();
           
           while(rs.next()){
            e=new Employee(rs.getInt("id"),
                   rs.getString("name"), 
                   rs.getString("designation"), 
                   rs.getString("salary"),
                   rs.getString("hire_date"),
                   rs.getString("department")
                  
           );
           
           }
           
           
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return e;
   }
    
}

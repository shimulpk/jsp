/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author hp
 */
public class Employee {
    
    private int id;
    private String name;
    private String designation;
    private String salary;
    private String hire_date;
    private String department;

    public Employee() {
    }

    public Employee(int id, String name, String designation, String salary, String hire_date, String department) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.hire_date = hire_date;
        this.department = department;
    }

    public Employee(String name, String designation, String salary, String hire_date, String department) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.hire_date = hire_date;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}

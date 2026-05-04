/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Student {
    
    private int roll;
    private String name;
    private String subjects;
    private String marks;
    private String departments;

    public Student() {
    }

    public Student(int roll, String name, String subjects, String marks, String departments) {
        this.roll = roll;
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
        this.departments = departments;
    }

    public Student(String name, String subjects, String marks, String departments) {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
        this.departments = departments;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    
   
    
    
    
    
    
}

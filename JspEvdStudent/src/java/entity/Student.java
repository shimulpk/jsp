/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author hp
 */
public class Student {
    private int id;
    private String name;
    private String clas;
    private String role;

    public Student() {
    }

    public Student(int id, String name, String clas, String role) {
        this.id = id;
        this.name = name;
        this.clas = clas;
        this.role = role;
    }

    public Student(String name, String clas, String role) {
        this.name = name;
        this.clas = clas;
        this.role = role;
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

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}

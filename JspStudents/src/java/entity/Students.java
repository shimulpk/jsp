/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author hp
 */
public class Students {
    private int id;
    private String name;
    private String email;
    private String dob;
    private String fee;
    private String department;

    public Students() {
    }

    public Students(int id, String name, String email, String dob, String fee, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.fee = fee;
        this.department = department;
    }

    public Students(String name, String email, String dob, String fee, String department) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.fee = fee;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}

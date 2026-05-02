/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

/**
 *
 * @author hp
 */
public class TeacherDao {
    
    // 🔹 SQL Queries
    private static final String INSERT_SQL =
            "INSERT INTO teacher(name, salary, designation) VALUES (?, ?, ?)";

    private static final String SELECT_ALL =
            "SELECT * FROM teacher";

    private static final String SELECT_BY_ID =
            "SELECT * FROM teacher WHERE id=?";

    private static final String UPDATE_SQL =
            "UPDATE teacher SET name=?, salary=?, designation=? WHERE id=?";

    private static final String DELETE_SQL =
            "DELETE FROM teacher WHERE id=?";

    // 🔥 1. Insert
    public void insertTeacher(Teacher t) {
        try (Connection con = DbUtil.getConnection;
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

            ps.setString(1, t.getName());
            ps.setDouble(2, t.getSalary());
            ps.setString(3, t.getDesignation());

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    // 🔥 2. Get All
    public List<Teacher> getAllTeachers() {
        List<Teacher> list = new ArrayList<>();

        try (Connection con = DbUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL)) {

            while (rs.next()) {
                Teacher t = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("designation")
                );
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔥 3. Get By ID
    public Teacher getTeacherById(int id) {
        Teacher t = null;

        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                t = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("designation")
                );
            }

        } catch (Exception e) {
        }

        return t;
    }

    // 🔥 4. Update
    public void updateTeacher(Teacher t) {
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {

            ps.setString(1, t.getName());
            ps.setDouble(2, t.getSalary());
            ps.setString(3, t.getDesignation());
            ps.setInt(4, t.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 5. Delete
    public void deleteTeacher(int id) {
        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

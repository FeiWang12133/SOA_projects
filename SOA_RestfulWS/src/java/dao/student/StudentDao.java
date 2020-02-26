/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.student;


import dao.student.Student;
import static com.oracle.nio.BufferSecrets.instance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author A00238100
 */
public enum StudentDao {
    instance;
        private Connection con = null;
    
    
    private StudentDao(){
        try{
            System.out.println("loading db driver");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("DB driver loaded");

            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/SOA_DB",
                "billy",
                "1234"
            );
        }
        catch(ClassNotFoundException ex){
            System.err.println("\nClassNotFoundException");
            ex.printStackTrace();

        }catch(SQLException ex){
            System.err.println("\nSQLException");
            ex.printStackTrace();
        }
        
    }
    
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from student");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String course = rs.getString("course");
                Student student = new Student(id, name, address, course);
                students.add(student);
            }
        }catch(SQLException ex){
            System.err.println("\nSQLException");
            ex.printStackTrace();
        }
        return students;
    }
    
    
    public List<Student> getStudent(int id) {
        List<Student> students = new ArrayList<Student>();
        try {
            PreparedStatement pstmt = con.prepareStatement("Select * from student where id=" + id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                String name = rs.getString("name");
                String address = rs.getString("address");
                String course = rs.getString("course");
                Student student = new Student(id, name, address, course);
                students.add(student);
            }
        } catch (SQLException ex) {
            System.out.println("get student did not work");
        }
        return students;
    }

    public void create(Student student) {

        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT MAX(id) AS \"MaxId\" FROM student");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int id = rs.getInt("MaxId");
            id += 1;
            System.out.println(id);
            String name = student.getName();
            String address = student.getAddress();
            String course = student.getCourse();
            PreparedStatement pstmt1 = con.prepareStatement("insert into student values(" + id + ",'" + name + "','" + address + "','" + course + "')");
            pstmt1.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("get student did not work");
        }

    }

    public void delete(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement("delete from student where id=" + id);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("delete did not work");
        }
    }
    
   
    
    
}

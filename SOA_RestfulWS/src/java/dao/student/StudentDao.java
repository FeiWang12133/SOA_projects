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
    private Map<Integer, Student> studentsMap = new HashMap<Integer, Student>();
    
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
            }
        }catch(SQLException ex){
            System.err.println("\nSQLException");
            ex.printStackTrace();
        }
        return students;
    }
    
    public Student editStudent(int id){
        return studentsMap.get(id);
    }
    
    public Student getStudent(int id){
        return studentsMap.get(id);
    }
    public void create(Student student){
        studentsMap.put(student.getId(), student);
    }
    
    public Student getNextId(int id){
        return studentsMap.get(id);
    }
    
    public void delete(int id){
        if(studentsMap.remove(id) != null){
            System.out.println("Removed");
            
        }else{
            System.out.println("Not Removed");
        }
    }
    
}

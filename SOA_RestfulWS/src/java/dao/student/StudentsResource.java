/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.student;

import dao.student.StudentDao;
import dao.student.Student;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author A00238100
 */
@Path("students")
public class StudentsResource {
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> getStudents(){
        System.out.println("Hello");
        return StudentDao.instance.getStudents();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{studentId}")
    public Student getStudent(@PathParam("studentId") String id){
        return StudentDao.instance.getStudent(Integer.parseInt(id));
    }
    
    @HEAD
    public Response doHead(){
        return Response
                .noContent()
                .status(Response.Status.NO_CONTENT)
                .build();
    }
    
    @OPTIONS
    public Response doOptions(){
        Set<String> api = new TreeSet<>();
        api.add("GET");
        api.add("POST");
        api.add("DELETE");
        api.add("HEAD");
        
        return Response
                .noContent()
                .allow(api)
                .status(Response.Status.NO_CONTENT)
                .build();
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void postStudent(
            @FormParam("id") String id,
            @FormParam("name") String name,
            @FormParam("address") String address,
            @FormParam("course") String course,
            @Context HttpServletResponse servletResponse) throws IOException {
        
        
        Student student = new Student();
        student.setId(Integer.parseInt(id));
        student.setName(name);
        student.setAddress(address);
        student.setCourse(course);
        StudentDao.instance.create(student);
        servletResponse.sendRedirect("../index.html");
        
        
    }
    
    @DELETE
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("{studentId}")
    public Response deleteStudent(@PathParam("studentId") String id,
            @Context HttpServletResponse servletResponse) throws IOException {
        StudentDao.instance.delete(Integer.parseInt(id));
        return Response.status(200).entity("OperationSuccess").build();
    }
    
    @PUT
    @Path("{studentId}")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void editStudent(@PathParam("studentId") Integer id){
        
    }
    
}
    
package com.oracle.cloud.javaee8.jsonb_jpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Stateless
@Path("employees")
public class EmployeesResource {
    
    @PersistenceContext
    EntityManager em;

    @GET
    @Path("{email}")
    public Response test(@PathParam("email") String email) {
//        Stream<Employee> emps = em.createNativeQuery("SELECT * FROM EMPLOYEES where E", Employee.class).getResultStream();
        System.out.println("Searching for employee - '"+ email +"'");
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.email = :email", Employee.class);
        query.setParameter("email", email);
        Stream<Employee> emps = query.getResultStream();
        Employee emp = null;
        try {
             emp = emps.filter((e) -> e.getEmail().equals(email)).findFirst().get();

        } catch (NoSuchElementException e) {
             return Response.status(404).entity("Employee '"+ email + "' not found").build();
        }
        
        System.out.println("got emp -- "+ emp);
        return Response.ok(emp).build();
        //return result;
    }
    
    @GET
    //@Path("all")
    public List<Employee> all() {
        List<Employee> emps = em.createNativeQuery("SELECT * FROM EMPLOYEES", Employee.class).getResultList();
        System.out.println("got emps -- "+ emps.size());
        return emps;
    }

}

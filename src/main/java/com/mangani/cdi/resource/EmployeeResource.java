package com.mangani.cdi.resource;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.request.PostRequest;
import com.mangani.cdi.type.GraduationType;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

@Path("/employees")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@ApplicationScoped
public class EmployeeResource {

    @GET
    public Response getEmployees() {

        EmployeeRequest employee = new EmployeeRequest();

        employee.setPost(new PostRequest());
        employee.getPost().setBaseSalary(BigDecimal.valueOf(17000));
        employee.getPost().setGraduation(GraduationType.DOCTORATE);

        employee.setGraduation(GraduationType.SPECIALIST);
        employee.setHiredIn(Short.valueOf("2019"));
        employee.setName("Paulo Sérgio Bruno");

        return Response.ok().entity(employee).build();
    }

}

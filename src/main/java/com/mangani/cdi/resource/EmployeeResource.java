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
import java.util.ArrayList;
import java.util.List;

@Path("/employees")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@ApplicationScoped
public class EmployeeResource {

    @GET
    public Response getEmployees() {

        List<EmployeeRequest> employees = new ArrayList<>();

        employees.add(new EmployeeRequest());
        employees.add(new EmployeeRequest());

        employees.get(0).setPost(new PostRequest());
        employees.get(0).getPost().setBaseSalary(BigDecimal.valueOf(17000));
        employees.get(0).getPost().setGraduation(GraduationType.SPECIALIST);

        employees.get(0).setGraduation(GraduationType.DOCTORATE);
        employees.get(0).setHiredIn(Short.valueOf("2019"));
        employees.get(0).setName("Paulo Sérgio Bruno");

        employees.get(1).setPost(new PostRequest());
        employees.get(1).getPost().setBaseSalary(BigDecimal.valueOf(10000));
        employees.get(1).getPost().setGraduation(GraduationType.MEDIUM);

        employees.get(1).setGraduation(GraduationType.SPECIALIST);
        employees.get(1).setHiredIn(Short.valueOf("2018"));
        employees.get(1).setName("Rosemeire Peixinho Dourado");

        return Response.ok().entity(employees).build();
    }
}

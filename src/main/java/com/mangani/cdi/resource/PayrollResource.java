package com.mangani.cdi.resource;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.service.PayrollService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payroll")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PayrollResource {

    private PayrollService payrollService;

    @Inject
    public void init(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @POST
    public Response payroll(List<EmployeeRequest> employees) {

        return Response.ok()
                .entity(this.payrollService.calculate(employees))
                .build();

    }
}

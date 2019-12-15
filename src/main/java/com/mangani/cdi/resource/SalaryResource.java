package com.mangani.cdi.resource;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.IncomeRateResponse;
import com.mangani.cdi.service.TaxCalculatorService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/salaries")
@ApplicationScoped
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class SalaryResource {

    @Inject
    @Named("taxCalculator")
    private TaxCalculatorService taxCalculator;

    @POST
    public Response calculateIncomeTax(EmployeeRequest employee) {

        IncomeRateResponse incomeRate = this.taxCalculator.calculateIncomeTax(employee);

        return Response.ok().entity(incomeRate).build();
    }

    @PostConstruct
    public void init() {
        System.out.println("SalaryResource is ready!");
    }
}

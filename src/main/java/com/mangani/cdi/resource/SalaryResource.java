package com.mangani.cdi.resource;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.IncomeRateResponse;
import com.mangani.cdi.service.TaxCalculatorService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
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

    private TaxCalculatorService taxCalculator;

    @Inject
    public void init(@Named("taxCalculator") TaxCalculatorService taxCalculator) {
        this.taxCalculator = taxCalculator;
    }


    @POST
    public Response calculateIncomeTax(@Valid EmployeeRequest employee) {

        IncomeRateResponse incomeRate = this.taxCalculator.calculateIncomeTax(employee);

        return Response.ok().entity(incomeRate).build();
    }

    @PostConstruct
    public void init() {
        System.out.println("SalaryResource is ready!");
    }
}

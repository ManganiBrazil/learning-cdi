package com.mangani.cdi.builder;

import com.mangani.cdi.converter.EmployeeConverter;
import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.EmployeeResponse;
import com.mangani.cdi.response.PayrollResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayrollBuilder {

    private static final EmployeeConverter EMPLOYEE_CONVERTER = new EmployeeConverter();

    private final Date dateCalculation;
    private final BigDecimal summation;
    private List<EmployeeResponse> employees;

    public PayrollBuilder(Date dateCalculation, BigDecimal summation) {
        this.dateCalculation = dateCalculation;
        this.summation = summation;
    }

    public PayrollBuilder withEmployees(List<EmployeeRequest> employees) {

        this.employees = new ArrayList<>();

        for (EmployeeRequest employeeRequest : employees) {
            this.employees.add(EMPLOYEE_CONVERTER.convert(employeeRequest));
        }

        return this;
    }

    public PayrollResponse build() {

        PayrollResponse payrollResponse = new PayrollResponse();
        payrollResponse.setDateCalculation(this.dateCalculation);
        payrollResponse.setSummation(this.summation);
        payrollResponse.setEmployees(this.employees);

        return payrollResponse;
    }
}

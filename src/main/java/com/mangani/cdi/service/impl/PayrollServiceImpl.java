package com.mangani.cdi.service.impl;

import com.mangani.cdi.builder.PayrollBuilder;
import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.PayrollResponse;
import com.mangani.cdi.service.PayrollService;
import com.mangani.cdi.service.SalaryCalculatorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class PayrollServiceImpl implements PayrollService {

    private SalaryCalculatorService salaryCalculator;

    @Inject
    public void init(@Named("salaryCalculator") SalaryCalculatorService salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }

    @Override
    public PayrollResponse calculate(List<EmployeeRequest> employees) {

        BigDecimal summation = BigDecimal.ZERO;

        for (EmployeeRequest employee : employees) {
            summation = summation.add(this.salaryCalculator.calculate(employee));
        }

        return new PayrollBuilder(new Date(), summation)
                .withEmployees(employees)
                .build();
    }
}
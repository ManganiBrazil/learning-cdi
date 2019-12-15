package com.mangani.cdi.service.impl;

import com.mangani.cdi.builder.IncomeRateBuilder;
import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.IncomeRateResponse;
import com.mangani.cdi.service.SalaryCalculatorService;
import com.mangani.cdi.service.TaxCalculatorService;
import com.mangani.cdi.type.AliquotType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;

@ApplicationScoped
@Named("taxCalculator")
public class TaxCalculatorServiceImpl implements TaxCalculatorService, Serializable {

    private SalaryCalculatorService salaryCalculator;

    @Inject
    public void init(@Named("salaryCalculator") SalaryCalculatorService salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }


    @Override
    public IncomeRateResponse calculateIncomeTax(EmployeeRequest employee) {

        BigDecimal salary = this.salaryCalculator.calculate(employee);

        AliquotType aliquot = AliquotType.fromSalary(salary);

        BigDecimal tax = salary.multiply(aliquot.getAliquotValue());

        return new IncomeRateBuilder(tax)
                .withAliquot(aliquot.getAliquotValue())
                .withBaseSalary(employee.getBaseSalary())
                .withTotalSalary(salary)
                .build();
    }
}

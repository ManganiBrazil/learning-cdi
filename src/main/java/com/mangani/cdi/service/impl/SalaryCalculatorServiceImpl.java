package com.mangani.cdi.service.impl;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.service.SalaryCalculatorService;
import com.mangani.cdi.service.SalaryReferenceService;
import com.mangani.cdi.type.GraduationType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.mangani.cdi.type.GraduationPercent.*;

@ApplicationScoped
@Named("salaryCalculator")
public class SalaryCalculatorServiceImpl implements SalaryCalculatorService, Serializable {

    @Override
    public BigDecimal calculate(EmployeeRequest employee) {

        BigDecimal salary = employee.getBaseSalary();
        GraduationType graduation = employee.getGraduation();
        GraduationType graduationForCharge = employee.getGraduationForCharge();

        salary = salary.multiply(GRADUATION_ABOVE_POST.getPercent());

        if (this.underGraduateDegree(graduation, graduationForCharge)) {
            salary = salary.multiply(UNDERGRADUATE_DEGREE.getPercent());
        }

        Integer actualYear = LocalDateTime.now().getYear();

        Integer workPeriod = actualYear - employee.getHiredIn();

        BigDecimal salaryIncrease = BigDecimal.valueOf(workPeriod / 100);

        salary = salary.multiply(BigDecimal.valueOf(1).add(salaryIncrease));

        if (this.workMoreThanFiveYears(workPeriod)) {
            salary = salary.multiply(MORE_THAN_FIVE_YEARS_WORKING.getPercent());
        }

        return salary;
    }

    private boolean underGraduateDegree(GraduationType graduation, GraduationType graduationForPost) {
        return graduation.compareTo(graduationForPost) < 0;
    }

    private boolean workMoreThanFiveYears(Integer workPeriod) {
        return workPeriod > 5;
    }

    @Override
    public void setSalaryReferenceService(SalaryReferenceService salaryReferenceService) {

    }
}

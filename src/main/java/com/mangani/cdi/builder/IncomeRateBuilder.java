package com.mangani.cdi.builder;

import com.mangani.cdi.response.IncomeRateResponse;

import java.math.BigDecimal;

public class IncomeRateBuilder {

    private final BigDecimal tax;
    private BigDecimal aliquot;
    private BigDecimal baseSalary;
    private BigDecimal totalSalary;

    public IncomeRateBuilder(BigDecimal tax) {
        this.tax = tax;
    }

    public IncomeRateBuilder withAliquot(BigDecimal aliquot) {
        this.aliquot = aliquot;
        return this;
    }

    public IncomeRateBuilder withBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public IncomeRateBuilder withTotalSalary(BigDecimal totalSalary) {
        this.totalSalary = totalSalary;
        return this;
    }

    public IncomeRateResponse build() {

        IncomeRateResponse incomeRate = new IncomeRateResponse();
        incomeRate.setTax(this.tax);
        incomeRate.setTotalSalary(this.totalSalary);
        incomeRate.setBaseSalary(this.baseSalary);
        incomeRate.setAliquot(this.aliquot);

        return incomeRate;
    }
}

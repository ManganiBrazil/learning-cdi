package com.mangani.cdi.type;

import com.mangani.cdi.bean.SalaryRange;

import java.math.BigDecimal;

public enum AliquotType {

    ALIQUOT_0(new SalaryRange(BigDecimal.ZERO, BigDecimal.valueOf(1710.78)), BigDecimal.ZERO, BigDecimal.ZERO),
    ALIQUOT_7_5(new SalaryRange(BigDecimal.valueOf(1710.78), BigDecimal.valueOf(2563.91)), BigDecimal.valueOf(0.075), BigDecimal.valueOf(128.31)),
    ALIQUOT_15(new SalaryRange(BigDecimal.valueOf(2563.91), BigDecimal.valueOf(3418.59)), BigDecimal.valueOf(0.15), BigDecimal.valueOf(320.60)),
    ALIQUOT_22_5(new SalaryRange(BigDecimal.valueOf(3418.59), BigDecimal.valueOf(4271.59)), BigDecimal.valueOf(0.225), BigDecimal.valueOf(577)),
    ALIQUOT_27_5(new SalaryRange(BigDecimal.valueOf(4271.59), BigDecimal.valueOf(Double.MAX_VALUE)), BigDecimal.valueOf(0.275), BigDecimal.valueOf(790.58));

    private final SalaryRange salaryRange;
    private final BigDecimal aliquotValue;
    private final BigDecimal deductInstallment;

    AliquotType(SalaryRange salaryRange, BigDecimal aliquotValue, BigDecimal deductInstallment) {
        this.salaryRange = salaryRange;
        this.aliquotValue = aliquotValue;
        this.deductInstallment = deductInstallment;
    }

    public static final AliquotType fromSalary(BigDecimal salary) {

        AliquotType aliquotType = null;

        for (AliquotType e : values()) {
            if (e.salaryRange.between(salary)) {
                aliquotType = e;
                break;
            }
        }

        if (aliquotType == null) {
            throw new IllegalArgumentException("Invalid salary");
        }

        return aliquotType;
    }

    public SalaryRange getSalaryRange() {
        return salaryRange;
    }

    public BigDecimal getAliquotValue() {
        return aliquotValue;
    }

    public BigDecimal getDeductInstallment() {
        return deductInstallment;
    }
}

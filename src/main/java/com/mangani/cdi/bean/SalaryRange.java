package com.mangani.cdi.bean;

import java.math.BigDecimal;

public class SalaryRange {

    private final BigDecimal min;
    private final BigDecimal max;

    public SalaryRange(BigDecimal min, BigDecimal max) {
        this.min = min;
        this.max = max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public boolean between(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("Invalid value!");
        }

        return value.compareTo(this.min) > 0 && value.compareTo(this.max) <= 0;
    }
}

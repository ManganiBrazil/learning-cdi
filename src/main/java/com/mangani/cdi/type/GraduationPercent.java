package com.mangani.cdi.type;

import java.math.BigDecimal;

public enum GraduationPercent {

    UNDERGRADUATE_DEGREE(BigDecimal.valueOf(0.8)),
    GRADUATION_ABOVE_POST(BigDecimal.valueOf(1.2)),
    MORE_THAN_FIVE_YEARS_WORKING(BigDecimal.valueOf(1.1));

    private final BigDecimal percent;

    GraduationPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public BigDecimal getPercent() {
        return percent;
    }
}

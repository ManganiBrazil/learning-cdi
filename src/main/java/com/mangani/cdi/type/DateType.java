package com.mangani.cdi.type;

public enum DateType {

    PAYROLL_DATE("dd/MM/yyyy hh:mm:ss");

    private final String format;

    DateType(String format) {
        this.format = format;
    }

    public String format() {
        return format;
    }
}

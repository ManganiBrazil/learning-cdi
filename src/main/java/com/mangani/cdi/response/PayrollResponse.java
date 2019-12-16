package com.mangani.cdi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mangani.cdi.deserializer.PayrollDateDeserializer;
import com.mangani.cdi.serializer.PayrollDateSerializer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PayrollResponse {

    @JsonProperty("date-calc")
    @NotNull(message = "date-calc cannot be null!")
    @JsonSerialize(using = PayrollDateSerializer.class)
    @JsonDeserialize(using = PayrollDateDeserializer.class)
    private Date dateCalculation;

    @NotNull(message = "value cannot be null")
    private BigDecimal summation;

    @NotEmpty(message = "employees list cannot be empty")
    private List<EmployeeResponse> employees;

    public Date getDateCalculation() {
        return dateCalculation;
    }

    public void setDateCalculation(Date dateCalculation) {
        this.dateCalculation = dateCalculation;
    }

    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }

    public BigDecimal getSummation() {
        return summation;
    }

    public void setSummation(BigDecimal summation) {
        this.summation = summation;
    }
}
package com.mangani.cdi.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mangani.cdi.type.GraduationType;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostRequest {

    @JsonProperty("base-salary")
    @NotNull(message = "Base salary is mandatory")
    private BigDecimal baseSalary;

    @NotNull(message = "Graduation is mandatory")
    private GraduationType graduation;

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public GraduationType getGraduation() {
        return graduation;
    }

    public void setGraduation(GraduationType graduation) {
        this.graduation = graduation;
    }
}

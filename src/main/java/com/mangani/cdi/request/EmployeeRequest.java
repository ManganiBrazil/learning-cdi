package com.mangani.cdi.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mangani.cdi.type.GraduationType;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static java.util.Optional.ofNullable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeRequest {

    @NotNull(message = "Employee name is mandatory")
    private String name;

    @NotNull(message = "Employee post is mandatory")
    private PostRequest post;

    @JsonProperty("hired-in")
    @NotNull(message = "Employee hiredIn is mandatory")
    private Short hiredIn;

    @NotNull(message = "Employee graduation is mandatory")
    private GraduationType graduation;

    @JsonIgnore
    public BigDecimal getBaseSalary() {
        return ofNullable(this.post).map(post -> post.getBaseSalary()).orElse(null);
    }

    @JsonIgnore
    public GraduationType getGraduationForCharge() {
        return ofNullable(this.post).map(post -> post.getGraduation()).orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostRequest getPost() {
        return post;
    }

    public void setPost(PostRequest post) {
        this.post = post;
    }

    public Short getHiredIn() {
        return hiredIn;
    }

    public void setHiredIn(Short hiredIn) {
        this.hiredIn = hiredIn;
    }

    public GraduationType getGraduation() {
        return graduation;
    }

    public void setGraduation(GraduationType graduation) {
        this.graduation = graduation;
    }
}

package com.mangani.cdi.service;

import com.mangani.cdi.request.PostRequest;

import java.math.BigDecimal;

public interface SalaryReferenceService {

    BigDecimal searchBaseSalary(PostRequest postRequest);
}

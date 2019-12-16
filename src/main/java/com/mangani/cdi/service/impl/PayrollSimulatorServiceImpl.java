package com.mangani.cdi.service.impl;

import com.mangani.cdi.qualifier.Simulator;
import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.PayrollResponse;
import com.mangani.cdi.service.PayrollService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@Simulator
@ApplicationScoped
public class PayrollSimulatorServiceImpl implements PayrollService {

    @Override
    public PayrollResponse calculate(List<EmployeeRequest> employees) {
        System.out.println("Just a simple payroll simulation!");
        return null;
    }
}

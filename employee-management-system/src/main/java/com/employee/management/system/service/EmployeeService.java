package com.employee.management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String addEmployee(Employee employee){
    	employeeRepository.save(employee);
    	return "Employee Added";
    }

    public String updateEmployee(Employee employee){
        Employee emp = getEmployee(employee.getId());
        emp.setName(employee.getName());
        employeeRepository.save(emp);
        return "Employee Updated";
    }

    public Employee getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}

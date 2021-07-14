package net.guides.springboot2.springboot2jpacrudexample.service;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee) throws ResourceNotFoundException;

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    void deleteEmployeeById(Long employeeId) throws ResourceNotFoundException;
}

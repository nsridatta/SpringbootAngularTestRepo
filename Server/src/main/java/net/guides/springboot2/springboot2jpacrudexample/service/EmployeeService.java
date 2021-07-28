package net.guides.springboot2.springboot2jpacrudexample.service;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee) throws ResourceNotFoundException;
    public List<Employee> getEmployeeByName(String name) throws ResourceNotFoundException;
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    public Page<Employee> findAllEmployeePages(Pageable pageable);
   /* List<Employee> findAllByCountry();
    List<Employee> findAllStateByCountry(String state);
    List<Employee> findAllCityByState(String city);*/

    void deleteEmployeeById(Long employeeId) throws ResourceNotFoundException;
}

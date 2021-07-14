package net.guides.springboot2.springboot2jpacrudexample.controller;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@Validated @RequestBody Employee employee) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

   /* @GetMapping("/employees?firstName={firstName}")
    public ResponseEntity<Employee> getEmployeeByName(@RequestParam("firstName") String firstName)
            throws ResourceNotFoundException {
        Employee employee = (Employee) employeeRepository.findByFirstName(firstName);
        return ResponseEntity.ok().body(employee);
    }*/

   @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
       employeeDetails.setId(employeeId);
       return ResponseEntity.ok().body(this.employeeService.updateEmployee(employeeDetails));
    }

    @DeleteMapping("/employees/{employeeId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable long employeeId) throws ResourceNotFoundException {
        this.employeeService.deleteEmployeeById(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

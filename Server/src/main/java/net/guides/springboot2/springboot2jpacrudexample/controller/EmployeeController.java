package net.guides.springboot2.springboot2jpacrudexample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(value="EmployeeController", description="Employee Info portal related Operations")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/pages")
    public Page<Employee> findAllEmployeePages(Pageable pageable){
        return employeeService.findAllEmployeePages(pageable);
    }

    @GetMapping("/employees/names")
    @ApiOperation(value = "View list of All Employees with names", response = Object.class)
    public ResponseEntity<List<Employee>> getEmployeesByNames(@RequestParam String name)
            throws ResourceNotFoundException {
        return new ResponseEntity<List<Employee>>(employeeRepository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/emailId")
    @ApiOperation(value = "View list of All Employees by emails", response = Object.class)
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String emailId) throws ResourceNotFoundException{
        return new ResponseEntity<Employee>(employeeRepository.findByEmailAddress(emailId),HttpStatus.OK);
    }

    @GetMapping("/employees/country")
    @ApiOperation(value = "View list of All Employees by countries", response = Object.class)
    public ResponseEntity<List<Employee>> getAllCountries(@RequestParam String country){
        return ResponseEntity.ok().body(employeeRepository.findByCountry(country));
    }

   @GetMapping("/employees/state")
   @ApiOperation(value = "View list of All Employees by states", response = Object.class)
    public ResponseEntity<List<Employee>> getEmployeesByState(@RequestParam String country) throws ResourceNotFoundException{
        return new ResponseEntity<List<Employee>>(employeeRepository.findByState(country),HttpStatus.OK);
    }

    @GetMapping("/employees/city")
    @ApiOperation(value = "View list of All Employees by cities", response = Object.class)
    public ResponseEntity<List<Employee>> getEmployeesByCity(@RequestParam String country, @RequestParam String state) throws ResourceNotFoundException{
        return new ResponseEntity<List<Employee>>(employeeRepository.findByCity(country,state),HttpStatus.OK);
    }

    @GetMapping(value = "/employees")
    @ApiOperation(value = "View list of All Employees", response = Object.class)
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    @ApiOperation(value = "View list of Employee by Id", response = Object.class)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/employees")
    @ApiOperation(value = "Register a employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(employeeRepository.save(employee));
    }

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

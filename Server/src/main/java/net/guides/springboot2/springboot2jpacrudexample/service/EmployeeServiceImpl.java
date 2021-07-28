package net.guides.springboot2.springboot2jpacrudexample.service;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @CachePut("updateemp")
    @Override
    public Employee updateEmployee(Employee employee) throws ResourceNotFoundException{
        Optional < Employee > updatedEmp = this.employeeRepository.findById(employee.getId());

        if (updatedEmp.isPresent()) {
            Employee employeeUpdate = updatedEmp.get();

            employeeUpdate.setName(employee.getName());
            employeeUpdate.setLastName(employee.getLastName());
            employeeUpdate.setEmailId(employee.getEmailId());
            employeeUpdate.setDateOfJoining(employee.getDateOfJoining());

            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
        }
    }

    @Cacheable("employees")
    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employeeId);
        }
    }

    @Override
    public Page<Employee> findAllEmployeePages(Pageable pageable) {
        pageable = PageRequest.of(0, 10);
        int totalPages = pageable.getPageSize();
        return employeeRepository.findAll(pageable);
    }

    @Cacheable("employeenames")
    @Override
    public List<Employee> getEmployeeByName(String name) throws ResourceNotFoundException {

        return this.employeeRepository.findByName(name);

    }

    @CacheEvict("deleteemp")
    @Override
    public void deleteEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
            this.employeeRepository.delete(employee);

    }

}

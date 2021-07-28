package net.guides.springboot2.springboot2jpacrudexample.repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    //Native Queries
    @Query(value = "select * from employees where email_id =:emailId", nativeQuery = true)
    Employee findByEmailAddress(String emailId);

    /*@Query(value = "select DISTINCT(e.country) as EmpCountries from employees e")
    List<Employee> findAllByCountry();*/

    @Query(value = "select * from employees e where e.country =:country", nativeQuery = true)
    public List<Employee> findByCountry(@Param("country") String country);

    @Query(value = "select * from employees e where e.country =:country", nativeQuery = true)
    List<Employee> findByState(@Param("country") String country);

    @Query(value = "select * from employees e where e.country =:country and e.state=:state", nativeQuery = true)
    List<Employee> findByCity(@Param("country") String country, @Param("state") String state);
}

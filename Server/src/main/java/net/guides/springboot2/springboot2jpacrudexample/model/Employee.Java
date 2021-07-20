package net.guides.springboot2.springboot2jpacrudexample.model;

import net.guides.springboot2.springboot2jpacrudexample.validator.DateVal;
import net.guides.springboot2.springboot2jpacrudexample.validator.EmailVal;
import javax.persistence.*;
import javax.validation.constraints.*;


/*@NamedQuery(name = "Employee.findByEmailAddress",
        query = "select e from Employee e where e.emailId = ?1")*/
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "First Name cannot be empty")
    private String name;
    @NotEmpty(message = "Last Name cannot be empty")
    private String lastName;
    @EmailVal
    @NotNull(message = "Email cannot be empty")
    private String emailId;
    @DateVal
    @NotNull(message = "Date of Joining cannot be empty")
    private String dateOfJoining;


    public Employee(){

    }

    public Employee(String name, String lastName, String emailId, String dateOfJoining) {
        this.name = name;
        this.lastName = lastName;
        this.emailId = emailId;
        this.dateOfJoining = dateOfJoining;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name="name", nullable = false, length = 10)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "lastName", nullable = false, length = 10)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "emailId", nullable = false, length = 30, unique = true)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "dateOfJoining", nullable = false)
    public String getDateOfJoining() {return dateOfJoining;}
    public void setDateOfJoining(String dateOfJoining) {this.dateOfJoining = dateOfJoining;}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}

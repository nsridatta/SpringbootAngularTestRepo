package net.guides.springboot2.springboot2jpacrudexample.model;

import net.guides.springboot2.springboot2jpacrudexample.validator.EmailVal;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private long id;
    @Size(min = 3, max = 10)
    private String firstName;
    @Size(min = 3, max = 10)
    private String lastName;
    @EmailVal
    @NotBlank(message = "Email cannot be blank")
    private String emailId;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotBlank(message = "First Name cannot be blank")
    @Column(name = "firstName", nullable = false, length = 10)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotBlank(message = "Last Name cannot be blank")
    @Column(name = "lastName", nullable = false, length = 10)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Email(message = "Email must be a valid email address")
    @Column(name = "emailId", nullable = false, length = 30)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}

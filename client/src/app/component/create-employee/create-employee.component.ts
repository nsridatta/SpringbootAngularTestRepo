import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import {EmployeeService } from 'src/app/service/employee.service';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";  
  // createEmployeeForm: FormGroup;
  // myform: FormGroup;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

    log(x){
      console.log(x);
    }
    
    ngOnInit() {
    

  }

  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      this.employee = new Employee();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    
    this.submitted = true;
    console.log("Form Submitted!");
    this.save();
  
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}

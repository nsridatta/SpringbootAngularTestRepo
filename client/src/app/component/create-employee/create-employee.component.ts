import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import {EmployeeService } from 'src/app/service/employee.service';
import { Router } from '@angular/router';
import { FormGroup, FormsModule,ReactiveFormsModule } from '@angular/forms';
import {FormControl, Validators, FormBuilder }  from '@angular/forms';

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

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit() {
    

  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Employee();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}

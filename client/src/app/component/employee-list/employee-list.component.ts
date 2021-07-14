import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/model/employee';
import {EmployeeService } from 'src/app/service/employee.service';
import { UpdateEmployeeComponent } from 'src/app/component/update-employee/update-employee.component'

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>;
  employee: Employee;
  id: number;

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService,
    private router: Router,) {}

  ngOnInit() {
    this.reloadData();
    this.employee = new Employee();

    this.id = this.route.snapshot.params['id'];
    
   

    this.employeeService.getEmployee(this.id)
      .subscribe(data => {
        this.employee = data;
      }, error => console.log(error));

  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
      this.employeeService.deleteEmployee(id)
        .subscribe(
          data => {            
            this.reloadData();
          },
          error => console.log(error));
    }

  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateEmployee(id: number) {
    this.router.navigate(['update', id]);
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}

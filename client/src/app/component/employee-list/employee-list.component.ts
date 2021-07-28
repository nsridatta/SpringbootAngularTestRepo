import { Component, OnInit, SimpleChange } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/model/employee';
import {EmployeeService } from 'src/app/service/employee.service';
import { UpdateEmployeeComponent } from 'src/app/component/update-employee/update-employee.component'
import { SimpleSmoothScrollService, ISimpleSmoothScrollOption } from 'ng2-simple-smooth-scroll';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];
  employee: Employee;
  id: number;
  searchedKeyword:string;
  name: any;
  p:number = 0;

  config: any;
  collection = { count: 60, data: [] };

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService,
              private router: Router, private smooth: SimpleSmoothScrollService) {

                //Create dummy data
    for (var i = 0; i < this.collection.count; i++) {
      this.collection.data.push(
        {
          id: i + 1,
          value: "items number " + (i + 1)
        }
      );
    }
    
                this.config = {
                  itemsPerPage: 5,
                  currentPage: 1,
                  totalItems: this.collection.count
                };
    }

    ngOnInit() {
      this.reloadData();
      
      this.employee = new Employee();      
      this.id = this.route.snapshot.params['id'];
      if(this.id){
        this.employeeService.getEmployee(this.id)
        .subscribe(data => {
          this.employee = data;
        }, error => console.log(error));
      }
      // this.employeeService.getEmployeesList().subscribe(res => this.searchText = res);    
  }
  key:string = 'id';
  reverse: boolean = false;
  sort(key){
    this.key = key;
    this.reverse=!this.reverse;
  }

  search(){
    if(this.name=="" || this.name==null){
      return this.ngOnInit();
    }else{
      this.employees = this.employees.filter(res => {
        return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    }

  }

  reloadData() {
    
    this.employeeService.getEmployeesList().subscribe(
      data => {
        this.employees = data;        
      }, 
      error => console.log(error)
    );
    
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

  pageChanged(event){
    this.config.currentPage = event;
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}

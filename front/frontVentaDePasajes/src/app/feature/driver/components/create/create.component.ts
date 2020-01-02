import { Component, OnInit } from '@angular/core';
import { Driver } from '../../shared/Driver';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CreateDriverService } from '../../service/create/create.service';
import { map, catchError  } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-create-driver',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateDriverComponent implements OnInit {

  driver: Driver = new Driver();

  constructor(private router: Router, private createDriver: CreateDriverService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    if ( form.invalid ) { return; }
    console.log(this.driver.name);
    console.log(this.driver.lastName);
    console.log(this.driver.identification);
    this.createDriver.createDriver(this.driver).subscribe( data => {
        this.driver = data;
        this.router.navigate(['/driver/list']);
      }
    );
  }

}

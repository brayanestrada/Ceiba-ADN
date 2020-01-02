import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Driver } from 'src/app/feature/driver/shared/Driver';
import { ListDriverService } from 'src/app/feature/driver/service/list/list.service';
import { Trip } from '../../../shared/Trip';
import { CreateService } from '../../../service/create/create.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-create-second',
  templateUrl: './create-second.component.html',
  styleUrls: ['./create-second.component.css']
})
export class CreateSecondComponent implements OnInit {

  driverModel: Driver[] = [];
  registerForm: FormGroup;
  submitted = false;
  tripModel: Trip = new Trip();
  pipe: DatePipe = new DatePipe('es-CO');
  tripDate: Date;

  constructor(private formBuilder: FormBuilder, private router: Router, private listDriver: ListDriverService,private createService: CreateService) { }

  ngOnInit() {

    this.listDriver.getDrivers().subscribe(( data: any) => {
      this.driverModel = data;
    });

    this.registerForm = this.formBuilder.group({
        startCity: ['', Validators.required],
        endCity: ['', Validators.required],
        seatsAvailable: ['', Validators.required],
        ticketAmount: ['', [Validators.required]],
        tripDate: ['', [Validators.required]],
        idDriver: ['', Validators.required],
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
        return;
    }
    this.tripModel = this.registerForm.value;
    this.getIdDriver(this.registerForm.value.idDriver);
    console.log(this.tripModel);
    this.createService.createTrip(this.tripModel)
    .subscribe(data => {
      this.tripModel = data;
      this.router.navigate(['/trip/list']);
      this.ngOnInit();
    });
  }

  onReset() {
      this.submitted = false;
      this.registerForm.reset();
  }

  getIdDriver(idDriver: any) {
    this.tripModel.idDriver = Number(idDriver);
  }

  convertDate() {
    this.tripModel.tripDate = this.pipe.transform(this.tripDate, 'MM-dd-yyyy');
    console.log(this.tripModel.tripDate);
  }
}

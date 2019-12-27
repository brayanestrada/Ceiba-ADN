import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Trip } from '../../shared/Trip';
import { CreateService } from '../../service/create/create.service';
import { ListDriverService } from '../../../driver/service/list/list.service';
import { Driver } from 'src/app/feature/driver/shared/Driver';


@Component({
  selector: 'app-create-trip',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateTripComponent implements OnInit {

  tripModel: Trip = new Trip();
  driverModel: Driver[] = [];

  constructor( private createService: CreateService, private router: Router, private listDriver: ListDriverService) { }

  ngOnInit() {
    this.listDriver.getDrivers().subscribe(( data: any) => {
      this.driverModel = data;
    });
  }

  onSubmit(form: NgForm) {
    console.log(form.value);
    if ( form.invalid ) {return; }
    this.createService.createTrip(form.value)
    .subscribe(data => {
      this.tripModel = data;
    });
    this.router.navigate(['/trips/list']);
  }

  getIdDriver(idDriver: any) {
    this.tripModel.idDriver = Number(idDriver);
  }

}

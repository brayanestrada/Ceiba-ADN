import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Trip } from '../../shared/Trip';
import { CreateService } from '../../service/create/create.service';
import { ListDriverService } from '../../../driver/service/list/list.service';
import { Driver } from 'src/app/feature/driver/shared/Driver';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-create-trip',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateTripComponent implements OnInit {

  tripModel: Trip = new Trip();
  driverModel: Driver[] = [];
  tripDate:Date;
  tripDateString:string;
  pipe: DatePipe = new DatePipe('es-CO');
  

  constructor(private createService: CreateService, private router: Router, private listDriver: ListDriverService) { }

  ngOnInit() {
    this.listDriver.getDrivers().subscribe(( data: any) => {
      this.driverModel = data;
    });
  }

  onSubmit(form: NgForm) {
    this.convertDate();
    console.log()
    if ( form.invalid ) {return; }
    this.getIdDriver(form.value.idDriver);
    this.createService.createTrip(form.value)
    .subscribe(data => {
      this.tripModel = data;    
      this.router.navigate(['/trip/list']);
      this.ngOnInit();
    });
  }

  getIdDriver(idDriver: any) {
    this.tripModel.idDriver = Number(idDriver);
  }

  convertDate(){
    this.tripModel.tripDate = this.pipe.transform(this.tripDate, 'MM-dd-yyyy');
    console.log(this.tripModel.tripDate);
  }

}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TripModule } from 'src/app/model/trip/trip.module';
import { CreateService } from 'src/app/service/trip/create.service' 

@Component({
  selector: 'app-create-trip',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateTripComponent implements OnInit {

  tripModel: TripModule = new TripModule();
  constructor( private createService : CreateService) { }

  ngOnInit() {
  }

  onSubmit(ngForm:NgForm){

  }
}

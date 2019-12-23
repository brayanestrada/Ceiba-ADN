import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TripModule } from 'src/app/model/trip/trip.module';
import { CreateService } from 'src/app/service/trip/create.service' 

@Component({
  selector: 'app-create-trip',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateTripComponent implements OnInit {

  tripModel: TripModule = new TripModule();

  constructor( private createService : CreateService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(form:NgForm){
    if( form.invalid ){return ;}
    this.createService.createTrip(form.value)
    .subscribe(data =>{
      this.tripModel = data;
    });
    this.router.navigate(['/trips']);
  }
}

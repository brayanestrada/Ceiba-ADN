import { Component, OnInit } from '@angular/core';
import { TripModule } from 'src/app/model/trip/trip.module';
import { ListService } from 'src/app/service/trip/list.service';

@Component({
  selector: 'app-list-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent implements OnInit {

  trips: TripModule[] = []; 

  constructor(private tripService: ListService) { 
    this.tripService.getTrips().subscribe((data:any) =>{
      this.trips = data;
    });

  }

  ngOnInit() {
  }

  onDelete(id:number){
    console.log(id);
  }
}

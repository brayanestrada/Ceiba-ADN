import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class TripModule {
  id: number;
  seatsAvailable: number;
  seatsSold: number;
  startCity: string;
  endCity: string;
  tripDate: string;
  idDriver: number;
  ticketAmount: number;
}

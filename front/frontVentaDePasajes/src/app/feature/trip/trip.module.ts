import { NgModule } from '@angular/core';
import { ListTripsComponent } from './components/list/list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TripRoutingModule } from './trip-routing.module';
import { CommonModule } from '@angular/common';
import { CreateSecondComponent } from './components/create/create-second/create-second.component';


@NgModule({
  declarations: [
    ListTripsComponent,
    CreateSecondComponent,
  ],
  imports: [
    CommonModule,
    TripRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
})
export class TripModule { }

import { CreateTripComponent } from './components/create/create.component';
import { NgModule } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { ListTripsComponent } from './components/list/list.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TripRoutingModule } from './trip-routing.module';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    CreateTripComponent,
    ListTripsComponent,
  ],
  imports: [
    CommonModule,
    TripRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: []
})
export class TripModule { }

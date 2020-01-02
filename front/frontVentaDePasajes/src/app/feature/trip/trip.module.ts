import { CreateTripComponent } from './components/create/create.component';
import { NgModule } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { ListTripsComponent } from './components/list/list.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TripRoutingModule } from './trip-routing.module';
import { CommonModule } from '@angular/common';
import { CreateSecondComponent } from './components/create/create-second/create-second.component';


@NgModule({
  declarations: [
    CreateTripComponent,
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

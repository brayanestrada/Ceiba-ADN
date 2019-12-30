import { CreateDriverComponent } from './components/create/create.component';
import { NgModule } from '@angular/core';
import { ListDriversComponent } from './components/list/list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { DriverRoutingModule } from './driver-routing.module';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    CreateDriverComponent,
    ListDriversComponent,
  ],
  imports: [
    CommonModule,
    DriverRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: []
})
export class DriverModule { }

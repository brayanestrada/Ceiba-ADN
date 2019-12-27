import { CreatePurchaseComponent } from './components/create/create.component';
import { NgModule } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { ListPurchaseComponent } from './components/list/list.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PurchaseRoutingModule } from './purchase-routing.module';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    CreatePurchaseComponent,
    ListPurchaseComponent,
  ],
  imports: [
    CommonModule,
    PurchaseRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: []
})
export class PurchaseModule { }

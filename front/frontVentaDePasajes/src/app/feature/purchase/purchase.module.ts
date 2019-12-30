import { CreatePurchaseComponent } from './components/create/create.component';
import { NgModule } from '@angular/core';
import { ListPurchaseComponent } from './components/list/list.component';
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

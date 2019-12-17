import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class PurchaseModule {
  id: number;
  numberPurchasedTickets: number;
  discountPercentage: number;
  totalPurchaseAmout: number;

 }

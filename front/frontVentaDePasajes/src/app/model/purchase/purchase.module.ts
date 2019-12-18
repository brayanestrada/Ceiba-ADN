import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [],
  providers: [],
  imports: [
    CommonModule
  ]
})
export class PurchaseModule {
  id: number;
  numberPurchasedTickets: number;
  ticketAmount: number;
  discountPercentage: number;
  totalPurchaseAmount: number;
 }

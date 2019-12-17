import { Component, OnInit } from '@angular/core';
import { PurchaseService } from 'src/app/service/purchase/purchase.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent {

  purchases: any[] = [];

  constructor(private purchase: PurchaseService) {
    console.log('Se ejecutó el constructor del Component service');
    this.purchase.getPurchase()
    .subscribe( (data: any) => {
      this.purchases = data;
      console.log(this.purchases);
    });
  }


}

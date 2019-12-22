import { Component } from '@angular/core';
import { PurchaseService } from 'src/app/service/purchase/purchase.service';
import { Routes, Router } from '@angular/router';
import { CreateComponent } from 'src/app/components/purchase/create/create.component';
import { PurchaseModule } from 'src/app/model/purchase/purchase.module';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent {

  purchases: PurchaseModule[] = [];
  routesLocal: Routes = [
    { path: 'createPurchase', component: CreateComponent}
  ];

  constructor(private purchase: PurchaseService, private router: Router) {
    console.log('Se ejecutó el constructor del Component service');
    this.purchase.getPurchase().subscribe( (data: any) => {
      this.purchases = data;
      console.log(this.purchases);
    });
  }

  onDelete(id:number){
    console.log(id);
  }

}

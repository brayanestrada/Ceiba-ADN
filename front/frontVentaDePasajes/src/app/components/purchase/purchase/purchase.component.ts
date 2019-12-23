import { Component, OnInit } from '@angular/core';
import { PurchaseService } from 'src/app/service/purchase/purchase.service';
import { DeleteService } from 'src/app/service/purchase/delete/delete.service';
import { Routes, Router } from '@angular/router';
import { CreateComponent } from 'src/app/components/purchase/create/create.component';
import { PurchaseModule } from 'src/app/model/purchase/purchase.module';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent{

  purchases: PurchaseModule[] = [];
  routesLocal: Routes = [
    { path: 'createPurchase', component: CreateComponent}
  ];

  constructor(private purchase: PurchaseService, private deleteService:DeleteService , private router: Router) {
    this.getPurchasesList();
  }

  getPurchasesList(){
    this.purchase.getPurchase().subscribe( (data: any) => {
      this.purchases = data;
    });
  }

  onDelete(purchase:PurchaseModule){
    this.deleteService.deletePurchase(purchase.id).subscribe();
    this.getPurchasesList();
  }

}
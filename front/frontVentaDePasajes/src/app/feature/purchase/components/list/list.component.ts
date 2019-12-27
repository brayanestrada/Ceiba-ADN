import { Component, OnInit } from '@angular/core';
import { ListService } from '../../service/list/list.service';
import { Purchase } from '../../shared/Purchase';
import { DeleteService } from '../../service/delete/delete.service';


@Component({
  selector: 'app-list-purchase',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListPurchaseComponent implements OnInit {

  purchases: Purchase[] = [];
  // routesLocal: Routes = [
  //  { path: 'createPurchase', component: CreateComponent}
  // ];

  ngOnInit() {
    this.getPurchasesList();
  }

  constructor(private purchase: ListService, private deleteService: DeleteService) {

  }

  getPurchasesList() {
    this.purchase.getPurchase().subscribe( (data: any) => {
      this.purchases = data;
    });
  }

  onDelete(purchase: Purchase) {
    this.deleteService.deletePurchase(purchase.id).subscribe((data) => {
      this.ngOnInit();
    });
  }


}

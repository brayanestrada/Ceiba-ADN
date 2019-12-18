import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError  } from 'rxjs/operators';
import { PurchaseModule } from 'src/app/model/purchase/purchase.module';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  constructor(private http: HttpClient, private purchaseBody: PurchaseModule) { console.log('Se ejecutó el constructor del create service')}

  url = 'http://localhost:8181/purchase/create';

  createPurchase() {
    const purchaseBody = {
      numberPurchasedTickets: 50,
      ticketAmount: 100
    };
    return this.http.post(this.url, purchaseBody)
      .pipe(
        map((data: PurchaseModule) => {
        return data;
      }), catchError( error => {
        return throwError( 'Something went wrong!' );
      })
    );
  }
}

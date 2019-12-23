import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError  } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  constructor(private http: HttpClient) { }

  createPurchase(tickets: number, tripId: number) {
    const purchaseBody = {
      numberPurchasedTickets: tickets,
      idTrip: tripId
    };
    return this.http.post(environment.apiUrl + 'purchase/Create', purchaseBody)
      .pipe(
        map((data: any) => {
        return data;
      }), catchError( error => {
        return throwError( 'Something went wrong!' );
      })
    );
  }
}

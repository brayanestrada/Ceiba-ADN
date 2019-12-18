import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  url = 'http://localhost:8181/purchase/list';
  constructor(private http: HttpClient) {
    console.log('Se ejecutó el constructor del Service purchase');
  }

  getPurchase() {
    return this.http.get(this.url);
  }

}

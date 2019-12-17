import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  constructor(private http: HttpClient) {
    console.log('Se ejecutó el constructor del Service purchase');
  }

  getPurchase() {
    return this.http.get('http://localhost:8181/purchase/list');
  }

}

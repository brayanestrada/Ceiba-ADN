import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  constructor(private http: HttpClient) {
    console.log('Se ejecutó el constructor del Service purchase');
  }

  getPurchase() {
    return this.http.get(environment.apiUrl + 'purchase/list');
  }
}

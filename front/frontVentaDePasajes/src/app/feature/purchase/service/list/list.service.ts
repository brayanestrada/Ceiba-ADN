import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  constructor(private http: HttpClient) {  }

  getPurchase() {
    return this.http.get('/api/purchase/list');
  }
}

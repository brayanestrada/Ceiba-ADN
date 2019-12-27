import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DeleteService {

  constructor(private http: HttpClient) { }

  deletePurchase(id: number) {
    return this.http.delete(environment.apiUrl + 'purchase/delete/' + id);
  }
}

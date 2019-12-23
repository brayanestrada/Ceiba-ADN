import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DeleteService {


  url = "http://localhost:8181/purchase/delete/"
  constructor(private http:HttpClient) { }

  deletePurchase(id:number){
    return this.http.delete(this.url + id);
  }
}

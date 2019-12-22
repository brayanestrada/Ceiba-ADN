import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  url = 'http://localhost:8181/trip/list';

  constructor(private http: HttpClient) { }
  
  getTrips(){
    return this.http.get(this.url);
  }
}
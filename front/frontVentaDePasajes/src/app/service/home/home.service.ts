import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { console.log('Se ejecutó el constructor del Home Service'); }

  getTRM() {
    return this.http.get('http://app.docm.co/prod/Dmservices/Utilities.svc/GetTRM')
    .subscribe(data => {
      console.log(data);
    });
  }
}

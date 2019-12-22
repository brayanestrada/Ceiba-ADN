import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { formatDate } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  value: number;
  constructor(private http: HttpClient) { console.log('Se ejecutó el constructor del Home Service'); }

  getTRM() {
    return this.http.get('https://trm-colombia.makaw-dev.now.sh/?date=2019-12-23');
  }
}

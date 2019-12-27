import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ListDriverService {

  constructor(private http: HttpClient) { }

  getDrivers() {
    return this.http.get(environment.apiUrl + 'driver/list');
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DeleteDriverService {

  constructor(private http: HttpClient) { }

  deleteDriver(id: number) {
    return this.http.delete('/api/driver/delete/' + id);
  }
}

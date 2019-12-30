import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError  } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from '../../../../../environments/environment';
import { Trip } from '../../shared/Trip';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  constructor(private http: HttpClient) { }

  createTrip(trip: Trip) {
    return this.http.post('/api/trip/create' , trip)
    .pipe(
      map((data: any) => {
      return data;
    }), catchError( error => {
      console.log(error);
      return throwError(error.message);
    })
    );
  }
}

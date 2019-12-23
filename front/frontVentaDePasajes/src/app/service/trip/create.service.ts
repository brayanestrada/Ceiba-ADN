import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TripModule } from 'src/app/model/trip/trip.module';
import { catchError , map} from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  constructor(private http: HttpClient) { }

  createTrip(trip: TripModule) {
    return this.http.post(environment.apiUrl + 'trip/create' , trip)
    .pipe(
      map((data: any) => {
      return data;
    }), catchError( error => {
      return throwError('Something went wrong!');
    })
    );
  }
}

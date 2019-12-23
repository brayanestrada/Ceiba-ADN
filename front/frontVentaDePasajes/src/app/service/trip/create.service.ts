import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TripModule } from 'src/app/model/trip/trip.module';
import { catchError , map} from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateService {

  constructor(private http: HttpClient) { }

  url = "http://localhost:8181/trip/create"

  createTrip(trip:TripModule){
    return this.http.post(this.url, trip)
    .pipe(
      map((data:any) =>{
      return data;
    }), catchError( error =>{
      return throwError('Something went wrong!');
    })
    );
  }
}

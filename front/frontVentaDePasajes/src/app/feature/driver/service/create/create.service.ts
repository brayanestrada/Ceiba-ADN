import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Driver } from '../../shared/Driver';
//import { environment } from '../../../../../environments/environment';
import { map, catchError  } from 'rxjs/operators';
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CreateDriverService {

  constructor(private http: HttpClient) { }

  createDriver(driver: Driver) {
    return this.http.post('/api/driver/create' , driver)
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

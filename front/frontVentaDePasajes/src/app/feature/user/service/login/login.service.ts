import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../../shared/Login';
import { environment } from '../../../../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private executed: any;
  constructor(private http: HttpClient) {
  }

  logIn(login: Login) {
    return this.http.post(environment.apiUrl + 'login', login);
  }
}

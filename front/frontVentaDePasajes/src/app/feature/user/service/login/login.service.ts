import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../../shared/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private executed: any;
  constructor(private http: HttpClient) {
  }

  logIn(login: Login) {
    return this.http.post('http://localhost:8181/login/login', login).subscribe(data => {
      this.executed = data['id'];
      if ( this.executed !== undefined && this.executed != null ) {
        return true;
      } else {
        return false;
      }
    });
  }
}

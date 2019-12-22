import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginModule } from 'src/app/model/user/login/login.module';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private executed:any;
  constructor(private http: HttpClient) {
    
  }

  logIn(login: LoginModule) {
    console.log(login.email);
    console.log(login.password);
    return this.http.post('http://localhost:8181/login/login', login).subscribe(data => {
      console.log(data['id']);
      this.executed=data['id'];
      if(this.executed != undefined && this.executed != null){
        return true;
      }else{
        return false;
      }
    });
  }
}

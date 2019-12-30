import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../../service/login/login.service';
import { Router } from '@angular/router';
import { Login } from '../../shared/Login';
import { User } from '../../shared/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login = new Login();
  user: User = new User();

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  onSubmit( form: NgForm ) {
    console.log(this.login.email);
    console.log(this.login.password);
    this.loginService.logIn(this.login).subscribe((data:any) => {
      this.user = data;
      console.log(this.user);
      this.router.navigate(['/purchase/list']);
    });
  }


}

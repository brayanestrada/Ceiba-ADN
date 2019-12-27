import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../../service/login/login.service';
import { Router } from '@angular/router';
import { Login } from '../../shared/Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login;

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  onSubmit( form: NgForm ) {
    this.login.email = form.value.email;
    this.login.password = form.value.password;
    this.router.navigate(['/purchase']);
  }


}

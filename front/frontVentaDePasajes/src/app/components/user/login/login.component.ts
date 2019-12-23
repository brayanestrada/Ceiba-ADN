import { Component, OnInit } from '@angular/core';
import { LoginModule } from 'src/app/model/user/login/login.module';
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/service/user/login.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  login: LoginModule = new LoginModule();

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  onSubmit( form: NgForm ) {
    this.login.email = form.value.email;
    this.login.password = form.value.password;
    this.router.navigate(['/purchase']);
  }

}
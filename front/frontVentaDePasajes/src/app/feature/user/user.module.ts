import { NgModule } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { LoginComponent } from './components/login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { CommonModule } from '@angular/common';
import { CreateUserComponent } from './components/create/create/create.component';

@NgModule({
  declarations: [
    LoginComponent,
    CreateUserComponent,
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: []
})
export class UserModule { }
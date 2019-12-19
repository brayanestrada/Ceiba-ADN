import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

// Rutas
import { AppRoutingModule } from './app-routing.module';

// Servicios
import { HomeService } from './service/home/home.service';
import { CreateService } from './service/purchase/create/create.service';

// Componentes
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { PurchaseComponent } from './components/purchase/purchase/purchase.component';
import { HomeComponent } from './components/home/home.component';
import { CreateComponent } from './components/purchase/create/create.component';
import { LoginComponent } from './components/user/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PurchaseComponent,
    HomeComponent,
    CreateComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    HomeService,
    CreateService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

// Rutas
import { AppRoutingModule } from './app-routing.module';

// Servicios
import { HomeService } from './service/home/home.service';

// Componentes
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { PurchaseComponent } from './components/purchase/purchase/purchase.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PurchaseComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [HomeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

// Rutas
import { AppRoutingModule } from './app-routing.module';

// Servicios
import { HomeService } from './feature/home/service/home/home.service';
import { CreateService } from './feature/purchase/service/create/create.service';
import { ListDriverService } from './feature/driver/service/list/list.service';

// Componentes
import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { ListPurchaseComponent } from './feature/purchase/components/list/list.component';
import { HomeComponent } from './feature/home/components/home/home.component';
import { CreatePurchaseComponent } from './feature/purchase/components/create/create.component';
import { LoginComponent } from './feature/user/components/login/login.component';
import { CreateDriverComponent } from './feature/driver/components/create/create.component';
import { ListDriversComponent } from './feature/driver/components/list/list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    CreateDriverComponent,
    ListDriversComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PurchaseComponent } from './components/purchase/purchase/purchase.component';
import { HomeComponent } from './components/home/home.component';
import { CreateComponent } from './components/purchase/create/create.component';
import { TripComponent } from './components/trip/trip/trip.component';
import { LoginComponent } from './components/user/login/login.component';
import { CreateTripComponent } from './components/trip/create/create.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'purchase', component: PurchaseComponent},
  { path: 'createpurchase', component: CreateComponent},
  { path: 'createtrip', component: CreateTripComponent},
  { path: 'trips', component: TripComponent},
  { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

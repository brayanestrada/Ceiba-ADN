import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './feature/home/components/home/home.component';
import { LoginComponent } from './feature/user/components/login/login.component';
import { ListDriversComponent } from './feature/driver/components/list/list.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'purchase', loadChildren:
      () => import('./feature/purchase/purchase.module').then(mod => mod.PurchaseModule)},
  { path: 'trip' , loadChildren :
      () => import('./feature/trip/trip.module').then(mod => mod.TripModule)},
  // { path: 'trip/create', component: CreateTripComponent},
  { path: 'driver/list', component: ListDriversComponent},
  // { path: 'trips/list', component: ListTripsComponent},
  { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

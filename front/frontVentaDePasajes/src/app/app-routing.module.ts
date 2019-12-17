import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PurchaseComponent } from './components/purchase/purchase/purchase.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'purchase', component: PurchaseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PurchaseComponent } from './components/purchase/purchase/purchase.component';
import { HomeComponent } from './components/home/home.component';
import { CreateComponent } from './components/purchase/create/create.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'purchase', component: PurchaseComponent},
  { path: 'createPurchase', component: CreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

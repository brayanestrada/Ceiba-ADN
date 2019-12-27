import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreatePurchaseComponent } from './components/create/create.component';
import { ListPurchaseComponent } from './components/list/list.component';


const routes: Routes = [
  { path: '',
    children : [
      { path: 'create', component: CreatePurchaseComponent},
      { path: 'list', component: ListPurchaseComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PurchaseRoutingModule { }

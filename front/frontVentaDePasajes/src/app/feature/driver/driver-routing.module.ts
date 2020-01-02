import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListDriversComponent } from './components/list/list.component';
import { CreateDriverComponent } from './components/create/create.component';

const routes: Routes = [
  { path: '',
    children : [
      { path: 'create', component: CreateDriverComponent},
      { path: 'list', component: ListDriversComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DriverRoutingModule { }

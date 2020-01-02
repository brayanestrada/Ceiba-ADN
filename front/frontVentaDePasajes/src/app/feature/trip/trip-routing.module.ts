import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateTripComponent } from './components/create/create.component';
import { ListTripsComponent } from './components/list/list.component';
import { CreateSecondComponent } from './components/create/create-second/create-second.component';


const routes: Routes = [
  { path: '',
    children : [
      { path: 'create', component: CreateTripComponent},
      { path: 'list', component: ListTripsComponent},
      { path: 'createSecond', component: CreateSecondComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TripRoutingModule { }

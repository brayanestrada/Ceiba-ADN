import { Component, OnInit } from '@angular/core';
import { TripModule } from 'src/app/model/trip/trip.module';
import { ListService } from 'src/app/service/trip/list.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { PurchaseModule } from 'src/app/model/purchase/purchase.module';
import { CreateService } from 'src/app/service/purchase/create/create.service';
import { CreateComponent } from 'src/app/components/purchase/create/create.component'
import { DeleteService } from 'src/app/service/trip/delete.service';

@Component({
  selector: 'app-list-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent{

  trips: TripModule[] = []; 
  purchase: PurchaseModule = new PurchaseModule();

  constructor(private tripService: ListService, private createPurhcaseService: CreateService, private router: Router, private deleteService:DeleteService ) { 
    this.tripService.getTrips().subscribe((data:any) =>{
      this.trips = data;
    });

  }

  onDelete(id:number){
    this.deleteService.deleteTrip(id).subscribe();
  }

  onCreate( form: NgForm,idTrip:number ) { 
    console.log(form.value.numberPurchasedTickets)
    if ( form.invalid || form.value.numberPurchasedTickets == 0 ) { return; }
    if(form.value.numberPurchasedTickets === 0){
      console.log('Error');
    }else{
      this.createPurhcaseService.createPurchase(form.value.numberPurchasedTickets, idTrip)
      .subscribe(data => {
        this.purchase = data;
      });
      this.router.navigate(['/purchase']);
    }
  }

}

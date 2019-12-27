import { Component, OnInit } from '@angular/core';
import { Trip } from '../../shared/Trip';
import { ListService } from '../../service/list/list.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Purchase } from '../../../purchase/shared/Purchase';
import { CreateService } from '../../../purchase/service/create/create.service';
import { DeleteService } from '../../service/delete/delete.service';
import { Driver } from 'src/app/feature/driver/shared/Driver';


@Component({
  selector: 'app-list-trip',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListTripsComponent implements OnInit {

  trips: Trip[] = [];
  purchase: Purchase = new Purchase();
  driver: Driver = new Driver();

  constructor(private tripService: ListService, private createPurhcaseService: CreateService,
    private router: Router, private deleteService: DeleteService ) {
      this.getTrips();
  }

  ngOnInit() {
    this.getTrips();
  }

  onDelete(id: number) {
    this.deleteService.deleteTrip(id).subscribe();
    this.getTrips();
  }

  onCreate( form: NgForm, idTrip: number ) {
    console.log(form.value.numberPurchasedTickets);
    if ( form.invalid || form.value.numberPurchasedTickets === 0 ) { return; }
    if (form.value.numberPurchasedTickets === 0) {
      console.log('Error');
    } else {
      this.createPurhcaseService.createPurchase(form.value.numberPurchasedTickets, idTrip)
      .subscribe(data => {
        this.purchase = data;
      });
      this.router.navigate(['/purchase/list']);
    }
  }

  getTrips() {
    this.tripService.getTrips().subscribe((data: any) => {
      this.trips = data;
    });
  }

}

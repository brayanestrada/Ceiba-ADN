import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Purchase } from '../../shared/Purchase';
import { CreateService } from '../../service/create/create.service';

@Component({
  selector: 'app-create-purchase',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreatePurchaseComponent {

  purchase: Purchase = new Purchase();

  constructor(private router: Router, private createPurchase: CreateService) {
  }

  idTrip: number;

  onSubmit( form: NgForm ) {
    form.value.idTrip = this.idTrip;
    if ( form.invalid ) { return; }
    this.createPurchase.createPurchase(form.value.numberPurchasedTickets, form.value.idTrip)
    .subscribe(data => {
      this.purchase = data;
      this.router.navigate(['/purchase']);
    });
  }

  buyTicket(idTrip: number) {
  }
}

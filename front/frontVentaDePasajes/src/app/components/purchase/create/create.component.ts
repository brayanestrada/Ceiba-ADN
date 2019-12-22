import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { PurchaseModule } from 'src/app/model/purchase/purchase.module';
import { CreateService } from 'src/app/service/purchase/create/create.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
  styles: [`
  .ng-invalid.ng-touched:not(form){
    border: 1px solid red;
  }`]
})
export class CreateComponent{


  purchase: PurchaseModule = new PurchaseModule();

  constructor(private router: Router, private createPurchase: CreateService) {
  }


  onSubmit( form: NgForm ) {
    console.log(form.value);
    if ( form.invalid ) { return; }
    this.createPurchase.createPurchase().subscribe(data => {
      this.purchase = data;
    });
    this.router.navigate(['/home']);
  }
}

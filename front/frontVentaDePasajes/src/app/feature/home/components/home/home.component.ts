import { Component } from '@angular/core';
import { HomeService } from '../../service/home/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  TRM: any;
  myDate = new Date();

  constructor(private home: HomeService) {
    this.home.getTRM().subscribe(data => {
      this.TRM = data['data']['value'];
    });
  }

}

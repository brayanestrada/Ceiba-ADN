import { Component, OnInit } from '@angular/core';
import { Driver } from '../../shared/Driver';
import { ListDriverService } from '../../service/list/list.service';

@Component({
  selector: 'app-list-driver',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListDriversComponent implements OnInit {

  drivers: Driver[] = [];

  constructor(private listDriverService: ListDriverService) { }

  ngOnInit() {
    this.getDrivers();
  }

  getDrivers() {
    this.listDriverService.getDrivers().subscribe((data: any) => {
      this.drivers = data;
    });
  }

}

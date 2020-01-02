import { Component, OnInit } from '@angular/core';
import { Driver } from '../../shared/Driver';
import { ListDriverService } from '../../service/list/list.service';
import { DeleteDriverService } from '../../service/delete/delete.service';

@Component({
  selector: 'app-list-driver',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListDriversComponent implements OnInit {

  drivers: Driver[] = [];

  constructor(private listDriverService: ListDriverService, private deleteService: DeleteDriverService) { }

  ngOnInit() {
    this.getDrivers();
  }

  onDelete(id: number) {
    this.deleteService.deleteDriver(id).subscribe((data: any) => {
      this.ngOnInit();
    });
  }

  getDrivers() {
    this.listDriverService.getDrivers().subscribe((data: any) => {
      this.drivers = data;
    });
  }

}

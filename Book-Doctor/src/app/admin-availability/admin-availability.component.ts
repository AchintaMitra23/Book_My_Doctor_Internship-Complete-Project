import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-availability',
  templateUrl: './admin-availability.component.html',
  styleUrls: ['./admin-availability.component.css']
})
export class AdminAvailabilityComponent implements OnInit {

  constructor(private _adminservice:AdminService) { }

  public  dates:any;
  speciality:string="";
  ngOnInit(): void
  {
    //this._adminservice.getDates().subscribe(data => this.dates = data);
  }

    public deleteDatesById(id:number)
    {
     this._adminservice.deleteAvailability(id).subscribe(()=>console.log("dates deleted"));

    }

}

import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-availability-dates-all',
  templateUrl: './availability-dates-all.component.html',
  styleUrls: ['./availability-dates-all.component.css']
})
export class AvailabilityDatesAllComponent implements OnInit {

  public availlist:any[]=[];
  constructor(private appService:AdminService) {
  }
  ngOnInit(): void {
    this.appService.getAllDates().subscribe(data=>{this.availlist=data});
  }
  deleteAvailability(id1:number){
    this.appService.deleteAvailability(id1).subscribe(()=>alert("Availability Dates deleted"));
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-appointment-all',
  templateUrl: './appointment-all.component.html',
  styleUrls: ['./appointment-all.component.css']
})
export class AppointmentAllComponent implements OnInit {

  
  public applist:any[]=[];
  constructor(private appService:AdminService) {
  }
  ngOnInit(): void {
    this.appService.getAllAppointments().subscribe(data=>{this.applist=data});
  }
  deleteAppointment(id1:number){
    this.appService.deleteAppointment(id1).subscribe(()=>console.log("appointment deleted"));
  }

}

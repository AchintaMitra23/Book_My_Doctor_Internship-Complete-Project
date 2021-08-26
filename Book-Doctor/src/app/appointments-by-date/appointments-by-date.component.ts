import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-appointments-by-date',
  templateUrl: './appointments-by-date.component.html',
  styleUrls: ['./appointments-by-date.component.css']
})
export class AppointmentsByDateComponent implements OnInit {

  // appoint:Appointment=new Appointment;
  applist:any[]=[];
  date:string="";
  constructor(private appService:AdminService) { }

  getAppointmentsByDate(){
    this.appService.getAppointmentsByDate(this.date).subscribe(data=>this.applist=data);
  }
  deleteAppointment(id1:number){
    this.appService.deleteAppointment(id1).subscribe(()=>alert("appointment deleted"));
  }
  ngOnInit(): void {
  }

}

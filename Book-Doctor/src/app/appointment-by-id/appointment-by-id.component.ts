import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-appointment-by-id',
  templateUrl: './appointment-by-id.component.html',
  styleUrls: ['./appointment-by-id.component.css']
})
export class AppointmentByIdComponent implements OnInit {

  appoint:any;
  id:number=0;
  constructor(private appService:AdminService) { }

  getAppointmentsById(){
    this.appService.getAppointmentById(this.id).subscribe(data=>this.appoint=data);
  }
  deleteAppointment(id1:number){
    this.appService.deleteAppointment(id1).subscribe(()=>alert("appointment deleted"));
  }
  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-appointment-by-doctor',
  templateUrl: './appointment-by-doctor.component.html',
  styleUrls: ['./appointment-by-doctor.component.css']
})
export class AppointmentByDoctorComponent implements OnInit {

  id:number=0;
  public applist:any[]=[];
  constructor(private appService:AdminService ) {
  }
  ngOnInit(): void {
    
  }
  getAppointmentsByDoctor(){
    this.appService.getAppointmentsByDoctor(this.id).subscribe(data=>{this.applist=data});
  }
  deleteAppointment(id1:number){
    this.appService.deleteAppointment(id1).subscribe(()=>alert("appointment deleted"));
  }
}

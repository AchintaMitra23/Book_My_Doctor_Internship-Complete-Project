import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorRegistrationService } from '../doctor-registration.service';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {

  id:number;

  public applist:any;
  constructor(private appService:DoctorRegistrationService ,private route:ActivatedRoute,private router:Router) {
    this.id = this.route.snapshot.params['id'];
  }
  ngOnInit(): void {
    this.appService.getAppointmentsByDoctor(this.id).subscribe(data=>{this.applist=data});
  }
  deleteAppointment(id1:number){
      var ans:boolean=confirm("are you sure you want to delete?");
      if(ans==true)
      {
    this.appService.deleteAppointment(id1).subscribe(()=>alert("appointment deleted"));
      }
  }

  appoint:any;
  giveRemark(id:any) {
    var ans:any = prompt("Enter Remarks : ");
    this.appService.getAppointmentById(id).subscribe(data => {
      data.remark = ans;
      data.appointmentStatus = "Checked";
      this.appService.updateAppointment(data).subscribe(data1 => console.log(data1));
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorRegistrationService } from '../doctor-registration.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent implements OnInit {

  id1:number;
  id2:number=0;
  applist:any[]=[];
  constructor(private appService:DoctorRegistrationService ,private route:ActivatedRoute,private router:Router, private loginService : LoginService) {
    this.id1=parseInt(this.route.snapshot.params['id']);
  }
  ngOnInit(): void {



  }
  getAppointmentsByDoc(){
    this.appService.getDoctorIdByUserID(this.id1).subscribe(data=>{
      // this.getAppointmentsByDoc(this.id2=data)
      this.id2=data;
      console.log(data);
      this.router.navigate(["appointment",this.id2]);
    });
  }
  getFeedbackByDoc()
  {
    this.appService.getDoctorIdByUserID(this.id1).subscribe(data=>{
      // this.getAppointmentsByDoc(this.id2=data)
      this.id2=data;
      this.router.navigate(["feedback",this.id2]);
    });
  }
  viewPatientHist(){
    this.appService.getDoctorIdByUserID(this.id1).subscribe(data=>{
      // this.getAppointmentsByDoc(this.id2=data)
      this.id2=data;
      this.router.navigate(["view-patients-history",this.id2]);
    });
  }

  public logout() {
    this.loginService.logoutUser(this.id1).subscribe(data => {
      if (data == true) {
        alert("Logged Out Successfully");
        this.router.navigate(['form']);
      }
    });
  }

  public gotoProfile() {
    this.appService.getDoctorIdByUserID(this.id1).subscribe(data=>{
      this.id2=data;
      this.router.navigate(["doctor-profile", this.id2]);
    });
  }



}

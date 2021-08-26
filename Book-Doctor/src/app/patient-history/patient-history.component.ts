import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DoctorRegistrationService } from '../doctor-registration.service';

@Component({
  selector: 'app-patient-history',
  templateUrl: './patient-history.component.html',
  styleUrls: ['./patient-history.component.css']
})
export class PatientHistoryComponent implements OnInit {

  id:number;
  public applist1:any[]=[];
  constructor(private appService:DoctorRegistrationService ,private route:ActivatedRoute) {
    this.id = this.route.snapshot.params['id'];
  }
  ngOnInit(): void {
    this.appService.viewPatientsHistory(this.id).subscribe(data=>{this.applist1=data});
  }
  deleteAppointment(id1:number){
    var ans:boolean=confirm("are you sure you want to delete?");
      if(ans==true)
      {
    this.appService.deleteAppointment(id1).subscribe(()=>alert("appointment deleted"));
      }
  }

}

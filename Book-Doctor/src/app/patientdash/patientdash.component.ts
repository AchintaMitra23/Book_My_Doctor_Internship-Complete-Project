import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientRegistrationService } from '../patient-registration.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-patientdash',
  templateUrl: './patientdash.component.html',
  styleUrls: ['./patientdash.component.css']
})
export class PatientdashComponent implements OnInit {
 id1:number;
id2:number=0;
  constructor(private route:ActivatedRoute,private router:Router,private patient:PatientRegistrationService, private loginService : LoginService) {
    this.id1=parseInt(this.route.snapshot.params['id']); //id=1, id1=userid
   }


  ngOnInit(): void {
  }
getPatientId()
{
   this.patient.getPatientIdByUserId(this.id1).subscribe(data=>{

     this.id2=data;    //id2=patient id=24
     console.log(this.id2);
     this.router.navigate(["viewownappointment",this.id2]);  //viewownappointment/24

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
      this.patient.getPatientIdByUserId(this.id1).subscribe(data=>{

        this.id2=data;
        this.router.navigate(["patient-profile",this.id2]);  

      });
    }
}

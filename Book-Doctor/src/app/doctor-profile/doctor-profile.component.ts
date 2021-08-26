import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { DoctorRegistrationService } from '../doctor-registration.service';

@Component({
  selector: 'app-doctor-profile',
  templateUrl: './doctor-profile.component.html',
  styleUrls: ['./doctor-profile.component.css']
})
export class DoctorProfileComponent implements OnInit {

  id1:number = 0;
  id2:number=0;
  pat:any;
  constructor(private route:ActivatedRoute,private router:Router,private doctor:DoctorRegistrationService, private fbuilder : FormBuilder, private adminService : AdminService) {
    this.id1=parseInt(this.route.snapshot.params['id']);
   }

   docForm = this.fbuilder.group({
    userName : [{value : '', disabled : true}, [Validators.required, Validators.pattern("^[A-Za-z]\\w{5,30}$")]],
    emailID : [{value : '', disabled : true}, [Validators.required, Validators.email]],
    chargesPerVisit : ['', [Validators.required]],
    mobileNo : ['', [Validators.required]],
    doctorName : ['', [Validators.required, Validators.pattern("^[A-Za-z]\\w{5,30}$")]]
  });

   ngOnInit() {
      this.doctor.getDoctorByDoctorID(this.id1).subscribe(data => {
        this.docForm.controls.userName.setValue(data.userId.userName),
        this.docForm.controls.emailID.setValue(data.userId.emailID),
        this.docForm.controls.chargesPerVisit.setValue(data.chargesPerVisit),
        this.docForm.controls.mobileNo.setValue(data.mobileNo),
        this.docForm.controls.doctorName.setValue(data.doctorName)
      });
   }

   public onSubmit() {
this.doctor.getDoctorByDoctorID(this.id1).subscribe(data => {
    data.chargesPerVisit = this.docForm.controls.chargesPerVisit.value;
    data.mobileNo = this.docForm.controls.mobileNo.value;
    data.doctorName = this.docForm.controls.doctorName.value;
    this.doctor.updateDoctor(data).subscribe(data1 => {
      alert("Hi " + data1.userId.userName + ", your profile has been updated successfully");
    });
  });
   }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientRegistrationService } from '../patient-registration.service';
import { FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-patient-profile',
  templateUrl: './patient-profile.component.html',
  styleUrls: ['./patient-profile.component.css']
})
export class PatientProfileComponent implements OnInit {

  id1:number = 0;
  id2:number=0;
  pat:any;
  constructor(private route:ActivatedRoute,private router:Router,private patient:PatientRegistrationService, private fbuilder : FormBuilder, private adminService : AdminService) {
    this.id1=parseInt(this.route.snapshot.params['id']);
   }

   patForm = this.fbuilder.group({
    userName : [{value : '', disabled: true}, [Validators.required, Validators.pattern("^[A-Za-z]\\w{5,30}$")]],
    emailID : [{value : '', disabled: true}, [Validators.required, Validators.email]],
    address : ['', [Validators.required]],
    mobileNo : ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
    patientName : ['', [Validators.required, Validators.pattern("^[A-Za-z]\\w{5,30}$")]]
  });
  ngOnInit(): void {
    this.patient.getPatientByPatientID(this.id1).subscribe(data => {
      this.patForm.controls.userName.setValue(data.userId.userName),
      this.patForm.controls.emailID.setValue(data.userId.emailID),
      this.patForm.controls.address.setValue(data.address),
      this.patForm.controls.mobileNo.setValue(data.mobileNo),
      this.patForm.controls.patientName.setValue(data.patientName)
    })
  }
  public onSubmit() {
    this.patient.getPatientByPatientID(this.id1).subscribe(data => {
      data.address = this.patForm.controls.address.value;
      data.mobileNo = this.patForm.controls.mobileNo.value;
      data.patientName = this.patForm.controls.patientName.value;
      this.patient.updatePatient(data).subscribe(data1 => {
        alert("Hi " + data1.userId.userName + ", your profile has been updated successfully");
      });
    });
  }
}

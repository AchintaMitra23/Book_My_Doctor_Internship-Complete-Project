import { Component, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { roleNameValidator } from '../CustomValidator/role.validator';
import { PatientRegistrationService } from '../patient-registration.service';
import { User } from '../user';
import { Patient } from '../patient';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient-reg',
  templateUrl: './patient-reg.component.html',
  styleUrls: ['./patient-reg.component.css']
})
export class PatientRegComponent implements OnInit {

  constructor(private fbuilder : FormBuilder, private regService : RegistrationService, private patService : PatientRegistrationService, private router : Router) { }

  ngOnInit(): void {
  }

  patForm = this.fbuilder.group({
    userName : ['', [Validators.required, Validators.pattern("^[A-Za-z]\\w{5,30}$")]],
    emailID : ['', [Validators.required, Validators.email]],
    password : ['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$"), Validators.minLength(8), Validators.maxLength(30)]],
    role : [{value : 'Patient', disabled : true}],
    userId : [],
    address : ['', [Validators.required]],
    age : ['', [Validators.required]],
    gender : ['', [Validators.required]],
    bloodGroup : ['', [Validators.required]],
    mobileNo : ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
    patientName : ['', [Validators.required]]
  });


  public onSubmit() {
    let userId = new User(this.patForm.controls.userName.value, this.patForm.controls.emailID.value, this.patForm.controls.password.value, this.patForm.controls.role.value);
    this.patService.registerPatient(new Patient(userId, this.patForm.controls.address.value, this.patForm.controls.age.value, this.patForm.controls.bloodGroup.value, this.patForm.controls.gender.value, this.patForm.controls.mobileNo.value, this.patForm.controls.patientName.value)).subscribe(data => {
      this.router.navigate(['form']);
      alert("Patient Has Registered Successfully with user id : "+data.userId.userId);
    });
  }
}


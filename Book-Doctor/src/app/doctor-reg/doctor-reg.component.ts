import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from '../user';
import { DoctorRegistrationService } from '../doctor-registration.service';
import { RegistrationService } from '../registration.service';
import { Doctor } from '../doctor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor-reg',
  templateUrl: './doctor-reg.component.html',
  styleUrls: ['./doctor-reg.component.css']
})
export class DoctorRegComponent implements OnInit {


  constructor(private fbuilder : FormBuilder, private regService : RegistrationService, private docService : DoctorRegistrationService, private router : Router) { }

  ngOnInit(): void {
  }

  docForm = this.fbuilder.group({
    userName : ['', [Validators.required, Validators.pattern("^[A-Za-z]\\w{5,30}$")]],
    emailID : ['', [Validators.required, Validators.email]],
    password : ['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$"), Validators.minLength(8), Validators.maxLength(30)]],
    role : [{value:'Doctor',disabled:true}],
    userId : [],
    chargesPerVisit : ['', [Validators.required]],
    mobileNo : ['', [Validators.required]],
    location : ['', [Validators.required]],
    hospitalName : ['', [Validators.required]],
    speciality : ['', [Validators.required]],
    doctorName : ['', [Validators.required]]
  });

  public onSubmit() {
    let userId = new User(this.docForm.controls.userName.value, this.docForm.controls.emailID.value, this.docForm.controls.password.value, this.docForm.controls.role.value);
    this.docService.registerDoctor(new Doctor(userId, this.docForm.controls.chargesPerVisit.value, this.docForm.controls.doctorName.value, this.docForm.controls.hospitalName.value, this.docForm.controls.location.value, this.docForm.controls.mobileNo.value, this.docForm.controls.speciality.value)).subscribe(data => {
      this.router.navigate(['form']);
      alert("Doctor Has Registered Successfully with user id : "+data.userId.userId);
    });
  }

}

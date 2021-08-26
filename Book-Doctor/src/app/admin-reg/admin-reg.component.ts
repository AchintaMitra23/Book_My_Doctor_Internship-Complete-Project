import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientRegistrationService } from '../patient-registration.service';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { AdminService } from '../admin.service';
import { Admin } from '../admin';

@Component({
  selector: 'app-admin-reg',
  templateUrl: './admin-reg.component.html',
  styleUrls: ['./admin-reg.component.css']
})
export class AdminRegComponent implements OnInit {

  constructor(private fbuilder : FormBuilder, private regService : RegistrationService, private adminService : AdminService, private router : Router) { }

  ngOnInit(): void {
  }

  adminForm = this.fbuilder.group({
    userName : ['', [Validators.required, Validators.pattern("^[A-Za-z]\\w{5,30}$")]],
    emailID : ['', [Validators.required, Validators.email]],
    password : ['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$"), Validators.minLength(8), Validators.maxLength(30)]],
    role : [{value : 'Admin', disabled : true}],
    userId : [],
    contactNumber : ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
    adminName : ['', [Validators.required]]
  });


  public onSubmit() {
    let userId = new User(this.adminForm.controls.userName.value, this.adminForm.controls.emailID.value, this.adminForm.controls.password.value, this.adminForm.controls.role.value);
    this.adminService.registerAdmin(new Admin(userId, this.adminForm.controls.adminName.value, this.adminForm.controls.contactNumber.value)).subscribe(data => {
      this.router.navigate(['form']);
      alert("Admin Has Registered Successfully with user id : "+data.userId.userId);
    });
  }

}

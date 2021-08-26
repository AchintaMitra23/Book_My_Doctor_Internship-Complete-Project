;import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { RegistrationService } from '../registration.service';
import { roleNameValidator } from '../CustomValidator/role.validator';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private fbuilder : FormBuilder, private regService : RegistrationService, private logService : LoginService, private route : ActivatedRoute, private router : Router) {

  }

  logForm = this.fbuilder.group({
    emailID : ['', [Validators.required]],
    password : ['', [Validators.required]],
  });


  ngOnInit(): void {

  }

  user:any = new User("", "", "", "");

  public onClick() {

    let user:User;
    this.logService.loginUser(this.logForm.controls.emailID.value, this.logForm.controls.password.value)
    .subscribe(data => {
      user = data;
      if (user == null) {
        this.router.navigate(['form']);
        alert("User doesn't exists");
      } else if (user.role.startsWith("P")){
        this.router.navigate(['patient-dashboard', user.userId]);
        alert("Hi " + user.userName + " you have successfully logged in as patient");
      }  else if (user.role.startsWith("D")){
        this.router.navigate(['doctor-dashboard', user.userId]);
        alert("Hi " + user.userName + " you have successfully logged in as doctor");
      }  else {
        this.router.navigate(['admin-dashboard', user.userId]);
        alert("Hi " + user.userName + " you have successfully logged in as admin");
      }
    });

  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(private fbuilder : FormBuilder, private loginService : LoginService) { }

  forgotForm = this.fbuilder.group({
    emailID : ['', [Validators.required, Validators.email]],
    newPass : ['', [Validators.required,Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$"), Validators.minLength(8), Validators.maxLength(30)]],
    confirmPass : ['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$"), Validators.minLength(8), Validators.maxLength(30)]],
  });

  ngOnInit(): void {

  }

  public onSubmit() {
    this.loginService.forgotPassword(this.forgotForm.controls.emailID.value, this.forgotForm.controls.newPass.value, this.forgotForm.controls.confirmPass.value).subscribe(data => console.log(data));
  }

}

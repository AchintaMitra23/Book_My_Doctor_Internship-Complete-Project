import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-patient-by-gender',
  templateUrl: './patient-by-gender.component.html',
  styleUrls: ['./patient-by-gender.component.css']
})
export class PatientByGenderComponent implements OnInit {

  public  patients:any;
  constructor(private _adminservice:AdminService) { }
 gender:string="";

  ngOnInit(): void {
  }

  public findPatientByGender()
  {
    this._adminservice.getPatientByGender(this.gender).subscribe(data => this.patients = data);
  }

}

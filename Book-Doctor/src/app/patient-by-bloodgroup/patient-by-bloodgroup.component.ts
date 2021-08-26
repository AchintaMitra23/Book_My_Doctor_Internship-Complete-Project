import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-patient-by-bloodgroup',
  templateUrl: './patient-by-bloodgroup.component.html',
  styleUrls: ['./patient-by-bloodgroup.component.css']
})
export class PatientByBloodgroupComponent implements OnInit {

  public  patients:any;
  constructor(private _adminservice:AdminService) { }
 bloodGroup:string="";

  ngOnInit(): void {
  }

  public findPatientByBloodGroup()
  {
    this._adminservice.getPatientByBloodGroup(this.bloodGroup).subscribe(data => this.patients = data);
  }

}

import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-patient-by-id',
  templateUrl: './patient-by-id.component.html',
  styleUrls: ['./patient-by-id.component.css']
})
export class PatientByIdComponent implements OnInit {

  public patients:any;
  patientId:number=0;
  
  constructor(private _adminservice:AdminService) { }


  ngOnInit(): void {
  }

  public findPatientById()
  {
    this._adminservice.getPatientById(this.patientId).subscribe(data => this.patients = data);
  }

}

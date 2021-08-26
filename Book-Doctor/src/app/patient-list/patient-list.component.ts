import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  public  patients:any;
  constructor(private _adminservice:AdminService) { }

  ngOnInit(): void {
    this._adminservice.getAllPatients().subscribe(data => this.patients = data);
  }

  public deletePatientById(id:number)
  {
   this._adminservice.deletePatient(id).subscribe(()=>alert("patient deleted"));

  }
}

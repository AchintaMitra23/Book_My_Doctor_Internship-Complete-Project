import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-appointment-by-patient',
  templateUrl: './appointment-by-patient.component.html',
  styleUrls: ['./appointment-by-patient.component.css']
})
export class AppointmentByPatientComponent implements OnInit {

  patientId:number=0;
  public applist:any;
  constructor(private _adminservice:AdminService) { }

  ngOnInit(): void {
  }

  public findAppointmentByPatient()
  {
    this._adminservice.getAppointmentsByPatient(this.patientId).subscribe(data => this.applist = data);
  }

}

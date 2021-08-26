import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { PatientRegistrationService } from '../patient-registration.service';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-doctor-by-speciality',
  templateUrl: './doctor-by-speciality.component.html',
  styleUrls: ['./doctor-by-speciality.component.css']
})
export class DoctorBySpecialityComponent implements OnInit {

  constructor(private _patientservice:PatientRegistrationService) { }

  public  doctors:Doctor[]=[];
  speciality:string="";
  location:string="";
  hospitalName:string="";
  ngOnInit(): void
  {

  }
  public findDoctorBySpeciality()
  {
    this._patientservice.getDoctorsBySpeciality(this.speciality).subscribe(data => this.doctors = data);
  }
  public findDoctorByLocation()
  {
    this._patientservice.getDoctorsByLocation(this.location).subscribe(data => this.doctors = data);
  }
  public findDoctorByHospitalName()
  {
    this._patientservice.getDoctorsByHospitalName(this.hospitalName).subscribe(data => this.doctors = data);
  }

}

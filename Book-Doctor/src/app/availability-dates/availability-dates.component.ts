import { Component, OnInit } from '@angular/core';
import { PatientRegistrationService } from '../patient-registration.service';
import { AvailibilityDates } from '../availibility-dates';

@Component({
  selector: 'app-availability-dates',
  templateUrl: './availability-dates.component.html',
  styleUrls: ['./availability-dates.component.css']
})
export class AvailabilityDatesComponent implements OnInit {

  constructor(private _patientservice:PatientRegistrationService) { }

  public  dates:AvailibilityDates[]=[];
  speciality:string="";
  ngOnInit(): void
  {
    this._patientservice.getDates().subscribe(data => this.dates = data);
  }



}

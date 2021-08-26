import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AvailabilityRegistrationService } from '../availability-registration.service';
import { AvailibilityDates } from '../availibility-dates';
import { DoctorRegistrationService } from '../doctor-registration.service';

@Component({
  selector: 'app-availability-dates-reg',
  templateUrl: './availability-dates-reg.component.html',
  styleUrls: ['./availability-dates-reg.component.css']
})
export class AvailabilityDatesRegComponent implements OnInit {

  constructor(private fbuilder : FormBuilder, private availService : AvailabilityRegistrationService, private doctorService : DoctorRegistrationService) { }

  ngOnInit(): void {
  }

  availForm = this.fbuilder.group({
    doctorId : ['', [Validators.required]],
    fromDate : ['', [Validators.required]],
    endDate : ['', [Validators.required]]
  });

  public onSubmit() {
    this.doctorService.getDoctorByDoctorID(this.availForm.controls.doctorId.value).subscribe(data => {
      this.availService.addAvailability(new AvailibilityDates(data, this.availForm.controls.fromDate.value, this.availForm.controls.endDate.value)).subscribe(data1 => {
        alert("Avalability Dates has been saved for doctor : " + data1.doctorId.doctorName + " with doctor id : " + data1.doctorId.doctorId);
        this.availForm.controls.doctorId.setValue('');
        this.availForm.controls.fromDate.setValue('');
        this.availForm.controls.endDate.setValue('');
      })
    });
  }

}

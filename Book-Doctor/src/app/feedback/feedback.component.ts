import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DoctorRegistrationService } from '../doctor-registration.service';
import { FeedbackRegistrationService } from '../feedback-registration.service';
import { PatientRegistrationService } from '../patient-registration.service';
import { Feedback } from '../feedback';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  constructor(private fbuilder : FormBuilder, private feedService : FeedbackRegistrationService, private patientService : PatientRegistrationService, private doctorService : DoctorRegistrationService) { }

  ngOnInit(): void {
  }

  feedForm = this.fbuilder.group({
    patientId : ['', [Validators.required]],
    doctorId : ['', [Validators.required]],
    rating : ['', [Validators.required]],
    feedbackComment : ['', Validators.required]
  });

  public onSubmit() {
    this.patientService.getPatientByPatientID(this.feedForm.controls.patientId.value).subscribe(data => {
      this.doctorService.getDoctorByDoctorID(this.feedForm.controls.doctorId.value).subscribe(data1 => {
        this.feedService.addFeedback(new Feedback(data1, data, this.feedForm.controls.feedbackComment.value, this.feedForm.controls.rating.value)).subscribe(data2 => {
          alert("Hi " + data2.patientId.patientName + " you have gave a feedback to doctor : " + data2.doctorId.doctorName + " with rating : " + data2.rating);
          this.feedForm.controls.patientId.setValue('');
          this.feedForm.controls.doctorId.setValue('');
          this.feedForm.controls.rating.setValue('');
          this.feedForm.controls.feedbackComment.setValue('');
        })
      })
    });
  }

}

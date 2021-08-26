import { Component, OnInit } from '@angular/core';
import { PatientRegistrationService } from '../patient-registration.service';

@Component({
  selector: 'app-feedback-all',
  templateUrl: './feedback-all.component.html',
  styleUrls: ['./feedback-all.component.css']
})
export class FeedbackAllComponent implements OnInit {

  public feedlist:any;
  constructor(private patientService:PatientRegistrationService) {

  }

  ngOnInit(): void {
    this.patientService.getFeedback().subscribe(data=>this.feedlist=data);

  }

}

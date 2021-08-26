import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FeedbackRegistrationService } from '../feedback-registration.service';
import { DoctorRegistrationService } from '../doctor-registration.service';

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent implements OnInit {

  public id:number;
  public feedlist:any[]=[];
  constructor(private doctorService:DoctorRegistrationService ,private route:ActivatedRoute) {
    this.id = this.route.snapshot.params['id'];
  }
  ngOnInit(): void {
    this.doctorService.getFeedbackByDoctor(this.id).subscribe(data=>this.feedlist=data);
  }


}

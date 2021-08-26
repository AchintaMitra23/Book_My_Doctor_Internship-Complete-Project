import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-feedback-by-doctor',
  templateUrl: './feedback-by-doctor.component.html',
  styleUrls: ['./feedback-by-doctor.component.css']
})
export class FeedbackByDoctorComponent implements OnInit {

  id:number=0;
  public feedlist:any[]=[];
  constructor(private appService:AdminService ) {
  }
  ngOnInit(): void {
    
  }
  getFeedbackByDoctor(){
    this.appService.getFeedbackByDoctor(this.id).subscribe(data=>{this.feedlist=data});
  }

}

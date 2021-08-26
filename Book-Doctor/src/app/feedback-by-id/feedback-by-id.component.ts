import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-feedback-by-id',
  templateUrl: './feedback-by-id.component.html',
  styleUrls: ['./feedback-by-id.component.css']
})
export class FeedbackByIdComponent implements OnInit {

  feed:any;
  id:number=0;
  constructor(private appService:AdminService) { }

  getFeedbackbyId(){
    this.appService.getFeedbackById(this.id).subscribe(data=>this.feed=data);
  }
  ngOnInit(): void {
  }

}

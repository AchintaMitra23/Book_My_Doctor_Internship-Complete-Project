import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Feedback } from './feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackRegistrationService {

  constructor(private httpService: HttpClient) { }

  public addFeedback(feedData:any) : Observable<Feedback> {
    return this.httpService.post<Feedback>("http://localhost:2245/api/feedback/AddFeedback", feedData);
  }
}

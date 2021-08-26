import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AvailibilityDates } from './availibility-dates';

@Injectable({
  providedIn: 'root'
})
export class AvailabilityRegistrationService {

  constructor(private httpService: HttpClient) { }

  public addAvailability(availData:any) : Observable<AvailibilityDates> {
    return this.httpService.post<AvailibilityDates>("http://localhost:2245/api/doctor/AddDates", availData);
  }

  public updateDates(availData:any) : Observable<AvailibilityDates> {
    return this.httpService.put<AvailibilityDates>("http://localhost:2245/api/doctor/DoctorAvailabilityDatesById", availData);
  }

}

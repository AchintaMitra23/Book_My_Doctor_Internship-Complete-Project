import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentRegistrationService {

  constructor(private httpService: HttpClient) { }

  public addAppointment(appointData:any) : Observable<Appointment> {
    return this.httpService.post<Appointment>("http://localhost:2245/api/appointment/AddAppointment", appointData);
  }


}

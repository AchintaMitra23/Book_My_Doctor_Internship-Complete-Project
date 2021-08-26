import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctor } from './doctor';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';
import { Feedback } from './feedback';

@Injectable({
  providedIn: 'root'
})
export class DoctorRegistrationService {

  constructor(private httpService: HttpClient) { }

  public registerDoctor(doctorData:any) : Observable<Doctor> {
    return this.httpService.post<Doctor>("http://localhost:2245/api/doctor/AddDoctor", doctorData);
  }

  public updateDoctor(doctorData:any) : Observable<Doctor> {
    return this.httpService.put<Doctor>("http://localhost:2245/api/doctor/UpdateDoctor", doctorData);
  }

  public getDoctorByDoctorID(id:number) : Observable<Doctor> {
    return this.httpService.get<Doctor>(`${"http://localhost:2245/api/doctor/GetDoctorById"}/${id}`);
  }

  getAppointmentsByDoctor(id:number):Observable<Appointment[]>{
    return this.httpService.get<Appointment[]>(`${"http://localhost:2245/api/appointment/GetLatestAppointments"}/${id}`);
 }
 getFeedbackByDoctor(id:number):Observable<Feedback[]>{
  return this.httpService.get<Feedback[]>(`${"http://localhost:2245/api/feedback/GetFeedBackByDoctor/"}${id}`);
 }
 getDoctorIdByUserID(id:number):Observable<number>{
    return this.httpService.get<number>(`${"http://localhost:2245/api/doctor/GetDoctorIdByUserId"}/${id}`);
 }
 viewPatientsHistory(id:number):Observable<Appointment[]>{
    return this.httpService.get<Appointment[]>(`${"http://localhost:2245/api/appointment/viewPatientsHistory"}/${id}`);
 }
 public deleteAppointment(id:number){
    return this.httpService.delete("http://localhost:2245/api/appointment/DeleteAppointmentById/"+id);
  }
  public updateAppointment(appointData:any) : Observable<Appointment> {
    return this.httpService.put<Appointment>("http://localhost:2245/api/appointment/UpdateAppointment", appointData);
  }
  public getAppointmentById(id:number) : Observable<Appointment>{
    return this.httpService.get<Appointment>("http://localhost:2245/api/appointment/GetAppointmentByID/"+id);
  }
}

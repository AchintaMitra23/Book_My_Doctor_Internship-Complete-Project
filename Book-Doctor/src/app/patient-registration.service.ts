import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from './patient';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';
import { AvailibilityDates } from './availibility-dates';
import { Doctor } from './doctor';
import { Feedback } from './feedback';

@Injectable({
  providedIn: 'root'
})
export class PatientRegistrationService {

  constructor(private http: HttpClient) { }

  public registerPatient(patientData:any) : Observable<Patient> {
    return this.http.post<Patient>("http://localhost:2245/api/patient/AddPatient", patientData);
  }

  public updatePatient(patientData:any) : Observable<Patient> {
    return this.http.put<Patient>("http://localhost:2245/api/patient/EditPatientProfile", patientData);
  }

  public getPatientByPatientID(id:number) : Observable<Patient> {
    return this.http.get<Patient>(`${"http://localhost:2245/api/patient/GetPatientByID"}/${id}`);
  }

  getPatientIdByUserId(id:number):Observable<number>{
    return this.http.get<number>(`${"http://localhost:2245/api/patient/GetPatientIdByUserId"}/${id}`); //id in number changing to string using $
  }
  getDates(): Observable<AvailibilityDates[]>   //as a response of http get request from doctor service to db,we get observable from db
  {
    return this.http.get<AvailibilityDates[]>("http://localhost:2245/api/doctor/GetAllDates");

  }
  getDoctorsBySpeciality(speciality:string): Observable<Doctor[]>   //as a response of http get request from doctor service to db,we get observable from db
   {
     return this.http.get<Doctor[]>(`${"http://localhost:2245/api/doctor/GetAllDoctorsBySpecility"}/${speciality}`);
   }
   getDoctorsByLocation(location:string): Observable<Doctor[]>   //as a response of http get request from doctor service to db,we get observable from db
   {
     return this.http.get<Doctor[]>("http://localhost:2245/api/doctor/GetAllDoctorsByLocation/"+location);

   }
   getDoctorsByHospitalName(hospitalName:string): Observable<Doctor[]>   //as a response of http get request from doctor service to db,we get observable from db
   {
     return this.http.get<Doctor[]>("http://localhost:2245/api/doctor/GetAllDoctorsByHospital/"+hospitalName);

   }
   getFeedback():Observable<Feedback[]>{
    return this.http.get<Feedback[]>("http://localhost:2245/api/feedback/GetAllFeedback");
 }
 getAppointmentsByPatient(id:number):Observable<Appointment[]>{
  return this.http.get<Appointment[]>("http://localhost:2245/api/appointment/GetAppointmentsByPatient/"+id);
  }
  public deleteAppointment(id:number){
    return this.http.delete("http://localhost:2245/api/appointment/DeleteAppointmentById/"+id);
  }
}

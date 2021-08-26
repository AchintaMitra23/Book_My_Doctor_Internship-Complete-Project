import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { Admin } from './admin';
import { Appointment } from './appointment';
import { AvailibilityDates } from './availibility-dates';
import { Doctor } from './doctor';
import { Feedback } from './feedback';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  public updateUser(userData:any) : Observable<User> {
    return this.http.put<User>("http://localhost:2245/api/user/UpdateUser", userData);
  }

  public updateAdmin(adminData:any) : Observable<Admin> {
    return this.http.put<Admin>("http://localhost:2245/api/admin/UpdateAdmin", adminData);
  }

  getAllAdmins():Observable<Admin[]>{
    return this.http.get<Admin[]>("http://localhost:2245/api/admin/GetAllAdmins");
  }
  getAllDates():Observable<AvailibilityDates[]>{
    return this.http.get<AvailibilityDates[]>("http://localhost:2245/api/doctor/GetAllDates");
  }
  getAllAppointments():Observable<Appointment[]>{
    return this.http.get<Appointment[]>("http://localhost:2245/api/appointment/GetAllAppointment");
  }
  getAppointmentById(id:number):Observable<Appointment>{
    return this.http.get<Appointment>("http://localhost:2245/api/appointment/GetAppointmentByID/"+id);
  }

  getAppointmentsByDoctor(id:number):Observable<Appointment[]>{
    return this.http.get<Appointment[]>("http://localhost:2245/api/appointment/GetAppointmentsByDoctor/"+id);
  }
 getAppointmentsByPatient(id:number):Observable<Appointment[]>{
  return this.http.get<Appointment[]>("http://localhost:2245/api/appointment/GetAppointmentsByPatient/"+id);
  }
  getAllFeedback():Observable<Feedback[]>{
  return this.http.get<Feedback[]>("http://localhost:2245/api/feedback/GetAllFeedback");
  }
  getFeedbackByDoctor(id:number):Observable<Feedback[]>{
    return this.http.get<Feedback[]>("http://localhost:2245/api/feedback/GetFeedBackByDoctor/"+id);
  }
  getFeedbackById(id:number):Observable<Feedback>{
    return this.http.get<Feedback>("http://localhost:2245/api/feedback/GetFeedbackById/"+id);
  }
  getAllPatients():Observable<Patient[]>{
    return this.http.get<Patient[]>("http://localhost:2245/api/patient/GetAllPatient");
  }
  getPatientById(id:number):Observable<Patient[]>{
    return this.http.get<Patient[]>("http://localhost:2245/api/patient/GetPatientByID/"+id);
  }
  getPatientByGender(gender:string):Observable<Patient[]>{
    return this.http.get<Patient[]>("http://localhost:2245/api/patient/GetPatientByGender/"+gender);
  }
  getPatientByBloodGroup(bg:string):Observable<Patient[]>{
    return this.http.get<Patient[]>("http://localhost:2245/api/patient/GetPatientByBloodGroup/"+bg);
  }
  getAllDoctors(): Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:2245/api/doctor/GetAllDoctor");
  }
  getAppointmentsByDate(date:string):Observable<Appointment[]>{
    return this.http.get<Appointment[]>("http://localhost:2245/api/appointment/GetAppointmentsByDate/"+date);
  }
  getDoctorById(id:number):Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:2245/api/doctor/GetDoctorById/"+id);
  }
  getDoctorBySpeciality(speciality:string):Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:2245/api/doctor/GetAllDoctorsBySpecility/"+speciality);
  }
  getDoctorByLocation(location:string):Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:2245/api/doctor/GetAllDoctorsByLocation/"+location);
  }
  getDoctorByHospital(hospital:string):Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:2245/api/doctor/GetAllDoctorsByHospital/"+hospital);
  }
  getAllUsers():Observable<User[]>{
    return this.http.get<User[]>("http://localhost:2245/api/user/GetAllUser");
  }
  getUserById(id:number):Observable<User>{
    return this.http.get<User>("http://localhost:2245/api/user/GetUserById/"+id);
  }
  getDoctorIdByUserID(id:number):Observable<number>{
    return this.http.get<number>(`${"http://localhost:2245/api/doctor/GetDoctorIdByUserId"}/${id}`);
  }
  public deleteUser(id:number){
    return this.http.delete("http://localhost:2245/api/user/DeleteUserById/"+id);
  }
  public deleteAdmin(id:number){
    return this.http.delete("http://localhost:2245/api/admin/DeleteAdminById/"+id);
  }
  public deletePatient(id:number){
    return this.http.delete("http://localhost:2245/api/patient/RemovePatientDetails/"+id);
  }
  public deleteDoctor(id:number){
    return this.http.delete("http://localhost:2245/api/doctor/RemoveDoctorById/"+id);
  }
  public deleteAvailability(id:number){
    return this.http.delete("http://localhost:2245/api/doctor/RemoveAvailability/"+id);
  }
  public deleteFeedback(id:number){
    return this.http.delete("http://localhost:2245/api/feedback/RemoveFeedback/"+id);
  }
  public deleteAppointment(id:number){
    return this.http.delete("http://localhost:2245/api/appointment/DeleteAppointmentById/"+id);
  }

  public registerAdmin(adminData:any) : Observable<Admin> {
    return this.http.post<Admin>("http://localhost:2245/api/admin/AddAdmin", adminData);
  }

  getAdminIdByUserId(id:number):Observable<number>{
    return this.http.get<number>(`${"http://localhost:2245/api/admin/GetAdminIdByUserId"}/${id}`); //id in number changing to string using $
  }
}

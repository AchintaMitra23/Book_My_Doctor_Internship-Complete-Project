import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TestComponent } from './test/test.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { FormComponent } from './form/form.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { PatientRegComponent } from './patient-reg/patient-reg.component';
import { DoctorRegComponent } from './doctor-reg/doctor-reg.component';
import { AvailabilityDatesRegComponent } from './availability-dates-reg/availability-dates-reg.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AppointmentAllComponent } from './appointment-all/appointment-all.component';
import { AppointmentByDoctorComponent } from './appointment-by-doctor/appointment-by-doctor.component';
import { AppointmentByIdComponent } from './appointment-by-id/appointment-by-id.component';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { AppointmentsByDateComponent } from './appointments-by-date/appointments-by-date.component';
import { AvailabilityDatesAllComponent } from './availability-dates-all/availability-dates-all.component';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { FeedbackByDoctorComponent } from './feedback-by-doctor/feedback-by-doctor.component';
import { FeedbackByIdComponent } from './feedback-by-id/feedback-by-id.component';
import { FeedbackListComponent } from './feedback-list/feedback-list.component';
import { PatientHistoryComponent } from './patient-history/patient-history.component';
import { AdminAvailabilityComponent } from './admin-availability/admin-availability.component';
import { AdminGetDoctorByIdComponent } from './admin-get-doctor-by-id/admin-get-doctor-by-id.component';
import { AdminListComponent } from './admin-list/admin-list.component';
import { AppointmentByPatientComponent } from './appointment-by-patient/appointment-by-patient.component';
import { AvailabilityDatesComponent } from './availability-dates/availability-dates.component';
import { DoctorBySpecialityComponent } from './doctor-by-speciality/doctor-by-speciality.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { OwnAppointmentComponent } from './own-appointment/own-appointment.component';
import { PatientByBloodgroupComponent } from './patient-by-bloodgroup/patient-by-bloodgroup.component';
import { PatientByGenderComponent } from './patient-by-gender/patient-by-gender.component';
import { PatientByIdComponent } from './patient-by-id/patient-by-id.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientdashComponent } from './patientdash/patientdash.component';
import { UserListComponent } from './user-list/user-list.component';
import { FeedbackAllComponent } from './feedback-all/feedback-all.component';
import { AdminRegComponent } from './admin-reg/admin-reg.component';
import { UserByIdComponent } from './user-by-id/user-by-id.component';
import { PatientProfileComponent } from './patient-profile/patient-profile.component';
import { DoctorProfileComponent } from './doctor-profile/doctor-profile.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    TestComponent,
    FormComponent,
    AppointmentComponent,
    FeedbackComponent,
    PatientRegComponent,
    DoctorRegComponent,
    AvailabilityDatesRegComponent,
    AppointmentListComponent,
    FeedbackListComponent,
    PatientHistoryComponent,
    DoctorDashboardComponent,
    AdminDashboardComponent,
    AppointmentByIdComponent,
    AvailabilityDatesAllComponent,
    AppointmentAllComponent,
    FeedbackByIdComponent,
    AppointmentsByDateComponent,
    FeedbackByDoctorComponent,
    AppointmentByDoctorComponent,

    DoctorListComponent,
    PatientdashComponent,
    AvailabilityDatesComponent,
    DoctorBySpecialityComponent,
    AdminListComponent,
    AdminGetDoctorByIdComponent,
    UserListComponent,
    PatientListComponent,
    PatientByIdComponent,
    PatientByGenderComponent,
    PatientByBloodgroupComponent,
    OwnAppointmentComponent,
    AppointmentByPatientComponent,
    AdminAvailabilityComponent,
    FeedbackAllComponent,
    AdminRegComponent,
    UserByIdComponent,
    PatientProfileComponent,
    DoctorProfileComponent,
    UserProfileComponent,
    ForgotPasswordComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

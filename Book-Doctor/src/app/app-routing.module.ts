import { AdminGetDoctorByIdComponent } from './admin-get-doctor-by-id/admin-get-doctor-by-id.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { FormComponent } from './form/form.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { PatientRegComponent } from './patient-reg/patient-reg.component';
import { DoctorRegComponent } from './doctor-reg/doctor-reg.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AvailabilityDatesRegComponent } from './availability-dates-reg/availability-dates-reg.component';
import { TestComponent } from './test/test.component';
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
import { AvailabilityDatesComponent } from './availability-dates/availability-dates.component';
import { DoctorBySpecialityComponent } from './doctor-by-speciality/doctor-by-speciality.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { OwnAppointmentComponent } from './own-appointment/own-appointment.component';
import { PatientdashComponent } from './patientdash/patientdash.component';
import { FeedbackAllComponent } from './feedback-all/feedback-all.component';
import { AdminListComponent } from './admin-list/admin-list.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientByIdComponent } from './patient-by-id/patient-by-id.component';
import { AppointmentByPatientComponent } from './appointment-by-patient/appointment-by-patient.component';
import { UserListComponent } from './user-list/user-list.component';
import { AdminRegComponent } from './admin-reg/admin-reg.component';
import { UserByIdComponent } from './user-by-id/user-by-id.component';
import { PatientProfileComponent } from './patient-profile/patient-profile.component';
import { DoctorProfileComponent } from './doctor-profile/doctor-profile.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'form', component: FormComponent },
  { path: 'appointment', component: AppointmentComponent },
  { path: 'feedback', component: FeedbackComponent },
  { path: 'patient-reg', component: PatientRegComponent },
  { path: 'doctor-reg', component: DoctorRegComponent },
  { path: 'admin-reg', component: AdminRegComponent },
  { path: 'availibility-dates-reg', component: AvailabilityDatesRegComponent },
  { path: 'test/:id', component: TestComponent },

  { path: 'doctor-dashboard/:id', component:DoctorDashboardComponent },
  { path: 'admin-dashboard/:id', component: AdminDashboardComponent },
  { path: 'patient-dashboard/:id',component:PatientdashComponent },

  { path: 'appointment/:id', component:AppointmentListComponent },
  { path: 'feedback/:id', component:FeedbackListComponent },
  { path: 'doctor-by-id', component: AdminGetDoctorByIdComponent },
  { path: 'all-appointments', component:AppointmentAllComponent },
  { path: 'appointment-by-id', component:AppointmentByIdComponent },
  { path: 'appointments-by-date', component:AppointmentsByDateComponent },
  { path: 'feedback-by-id', component:FeedbackByIdComponent },
  { path: 'get-all-dates', component:AvailabilityDatesAllComponent },
  { path: 'appointments-by-doc', component:AppointmentByDoctorComponent },
  { path: 'appointments-by-pat', component: AppointmentByPatientComponent},
  { path: 'feedback-by-doc', component:FeedbackByDoctorComponent },
  { path: 'view-patients-history/:id', component:PatientHistoryComponent },
  { path: 'viewalldoctor',component:DoctorListComponent },
  { path: 'patient-by-id', component: PatientByIdComponent },
  { path: 'user-by-id', component: UserByIdComponent },
  { path: 'allfeedback',component:FeedbackAllComponent },
  { path: 'viewalldates',component:AvailabilityDatesComponent },
  { path: 'viewdoctorbyspecialist',component:DoctorBySpecialityComponent },
  { path: 'viewownappointment/:id',component:OwnAppointmentComponent },

  { path: 'patient-list', component: PatientListComponent },
  { path: 'admin-list', component: AdminListComponent },
  { path: 'user-list', component: UserListComponent },

  { path: 'patient-profile/:id', component: PatientProfileComponent },
  { path: 'doctor-profile/:id', component: DoctorProfileComponent },

  { path: 'forgot-password', component: ForgotPasswordComponent },

  { path: '**', component: PageNotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

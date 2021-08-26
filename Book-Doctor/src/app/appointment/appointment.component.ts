import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AppointmentRegistrationService } from '../appointment-registration.service';
import { PatientRegistrationService } from '../patient-registration.service';
import { DoctorRegistrationService } from '../doctor-registration.service';
import { Appointment } from '../appointment';
import { Patient } from '../patient';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  constructor(private fbuilder : FormBuilder, private appointService : AppointmentRegistrationService, private patientService : PatientRegistrationService, private doctorService : DoctorRegistrationService) { }

  ngOnInit(): void {
  }

  appForm = this.fbuilder.group({
    patientId : ['', [Validators.required]],
    doctorId : ['', [Validators.required]],
    appointmentDate : ['', [Validators.required]],
    appointmentStatus : [{value : 'Ongoing', disabled : true}],
    remark : [{value : 'N/A', disabled : true}]
  });

  public onSubmit() {
    this.patientService.getPatientByPatientID(this.appForm.controls.patientId.value).subscribe(data => {
      this.doctorService.getDoctorByDoctorID(this.appForm.controls.doctorId.value).subscribe(data1 => {
        this.appointService.addAppointment(new Appointment(data1, data, this.appForm.controls.appointmentDate.value)).subscribe(data2 => {
          alert("Hi " + data2.patientId.patientName + " you have make an appointment with doctor : " + data2.doctorId.doctorName + " on : " + data2.appointmentDate);
          this.appForm.controls.patientId.setValue('');
          this.appForm.controls.doctorId.setValue('');
          this.appForm.controls.appointmentDate.setValue('');
        })
      })
    });
  }

}

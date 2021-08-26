import { Patient } from './patient';
import { Doctor } from './doctor';

export class Appointment {
  appointmentDate : string;
  appointmentId : number = 0;
  appointmentStatus : string;
  doctorId : Doctor;
  patientId : Patient;
  remark : string;

  constructor(doctorId:Doctor, patientId:Patient, appointmentDate:string) {
    this.doctorId = doctorId;
    this.patientId = patientId;
    this.appointmentDate = appointmentDate;
    this.appointmentStatus = "Ongoing";
    this.remark = "N/A";
  }
}

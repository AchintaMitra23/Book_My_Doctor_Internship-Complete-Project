import { Doctor } from './doctor';
import { Patient } from './patient';

export class Feedback {
  doctorId : Doctor;
  feedbackComment : string;
  feedbackId : number = 0;
  patientId : Patient;
  rating : number;

  constructor(doctorId:Doctor, patientId:Patient, feedbackComment:string, rating:number) {
    this.doctorId = doctorId;
    this.patientId = patientId;
    this.feedbackComment = feedbackComment;
    this.rating = rating;
  }
}

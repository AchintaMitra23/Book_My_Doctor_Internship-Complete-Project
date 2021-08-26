import { Doctor } from './doctor';
import { User } from './user';
export class AvailibilityDates {
  availibityId : number = 0;
  doctorId : Doctor = new Doctor(new User("", "", "", ""), 0, "", "", "", 0, "");
  fromDate : string;
  endDate : string;

  constructor(doctorId:Doctor, fromDate:string, endDate:string) {
    this.doctorId = doctorId;
    this.fromDate = fromDate;
    this.endDate = endDate;
  }
}

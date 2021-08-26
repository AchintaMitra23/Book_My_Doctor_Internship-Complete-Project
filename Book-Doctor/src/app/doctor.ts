import { User } from './user';
export class Doctor {
  chargesPerVisit : number= 0;
  doctorId : number = 0;
  doctorName : string= "";
  hospitalName : string ="";
  location : string ="";
  mobileNo : number =0;
  speciality : string ="";
  userId : User;

  constructor(userId:User, chargesPerVisit:number, doctorName:string, hospitalName:string, location:string, mobileNo:number, speciality:string) {
    this.userId = userId;
    this.chargesPerVisit = chargesPerVisit;
    this.doctorName = doctorName;
    this.hospitalName = hospitalName;
    this.location = location;
    this.mobileNo = mobileNo;
    this.speciality = speciality;
  }

}



import { User } from './user';
export class Patient {
  address  : string = "";
  age : number = 0;
  bloodGroup : string = "";
  gender : string = "";
  mobileNo : number = 0;
  patientId : number = 0;
  patientName : string = "";
  userId : User;

  constructor(userId:User, address:string, age:number, bloodGroup:string, gender:string, mobileNo:number, patientName:string) {
    this.userId = userId;
    this.address = address;
    this.age = age;
    this.bloodGroup = bloodGroup;
    this.gender = gender;
    this.mobileNo = mobileNo;
    this.patientName = patientName;
  }
}

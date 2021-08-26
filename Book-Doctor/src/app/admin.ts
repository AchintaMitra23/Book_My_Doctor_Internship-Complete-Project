import { User } from './user';
export class Admin {
  adminId : number = 0;
  adminName :string = "";
  contactNumber : number = 0;
  userId : User;

  constructor(userId:User, adminName:string, contactNumber:number) {
    this.userId = userId;
    this.adminName = adminName;
    this.contactNumber = contactNumber;
  }
}

export class User {
    emailID:string="";
    loggedIn:boolean=false;
    password: string="";
    role: string="";
    userId:number=0;
    userName: string="";

    constructor(userName:string, emailID:string, password:string, role:string) {
      this.userName = userName;
      this.emailID = emailID;
      this.password = password;
      this.role = role;
      this.loggedIn = false;
    }
}

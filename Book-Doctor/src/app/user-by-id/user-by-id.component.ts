import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-user-by-id',
  templateUrl: './user-by-id.component.html',
  styleUrls: ['./user-by-id.component.css']
})
export class UserByIdComponent implements OnInit {

  public  users:any;
  constructor(private _adminservice:AdminService) { }
 userId:number=0;

  ngOnInit(): void {
  }

  public findUserById()
  {
    this._adminservice.getUserById(this.userId).subscribe(data => this.users = data);
  }
  public deleteUserById(id:number)
  {
    var ans:boolean=confirm("are you sure you want to delete?");
    if(ans==true)
    {
      this._adminservice.deleteUser(id).subscribe(()=>alert("user deleted"));

    }

  }


}

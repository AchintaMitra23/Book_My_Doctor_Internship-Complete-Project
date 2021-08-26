import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { User } from '../user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private _adminservice:AdminService) { }

  public  users:User[]=[];
  userId:number=0;

  ngOnInit(): void
  {
    this._adminservice.getAllUsers().subscribe(data => this.users = data);
  }
  // public findUserById()
  // {
  //   this._userservice.getUserById(this.userId).subscribe(data => this.users = data);
  // }

  public deleteUserById(id:number)
  {
   this._adminservice.deleteUser(id).subscribe(()=>console.log("user deleted"));

  }


}

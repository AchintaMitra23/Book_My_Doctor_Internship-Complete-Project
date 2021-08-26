import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {

  constructor(private _adminservice:AdminService) { }

  public  admins:Admin[]=[]; 
  ngOnInit(): void 
  {
    this._adminservice.getAllAdmins().subscribe(data => this.admins = data);
  }

  public deleteAdminById(id:number)
  {
   this._adminservice.deleteAdmin(id).subscribe(()=>console.log("admin deleted"));
  
  }
}

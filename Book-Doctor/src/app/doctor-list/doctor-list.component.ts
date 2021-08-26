import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  constructor(private _adminservice:AdminService) { }

  public  doctors:Doctor[]=[];
  ngOnInit(): void
  {
    this._adminservice.getAllDoctors().subscribe(data => this.doctors = data);
  }
  public deleteDoctorById(id:number)
  {
   this._adminservice.deleteDoctor(id).subscribe(()=>console.log("doctor deleted"));

  }



}

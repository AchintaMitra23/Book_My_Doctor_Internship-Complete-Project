import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-get-doctor-by-id',
  templateUrl: './admin-get-doctor-by-id.component.html',
  styleUrls: ['./admin-get-doctor-by-id.component.css']
})
export class AdminGetDoctorByIdComponent implements OnInit {

  constructor(private _adminservice:AdminService) { }

  public  doctors:any;
  doctorId:number=0;

  ngOnInit(): void {

  }
  public findDoctorById()
  {
    this._adminservice.getDoctorById(this.doctorId).subscribe(data => this.doctors = data);
  }
  public deleteDoctorById(id:number)
  {
    var ans:boolean=confirm("are you sure you want to delete?");
    if(ans==true)
    {
      this._adminservice.deleteDoctor(id).subscribe(()=>alert("doctor deleted"));

    }

  }

}

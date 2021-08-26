import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Appointment } from '../appointment';
import { PatientRegistrationService } from '../patient-registration.service';

@Component({
  selector: 'app-own-appointment',
  templateUrl: './own-appointment.component.html',
  styleUrls: ['./own-appointment.component.css']
})
export class OwnAppointmentComponent implements OnInit {
id:number;
  public  appointment:Appointment[]=[];
  constructor(private _patientservice:PatientRegistrationService,private route:ActivatedRoute) {
    this.id=parseInt(this.route.snapshot.params['id']);
  }
 patientId:number=0;

  ngOnInit(): void {
    this._patientservice.getAppointmentsByPatient(this.id).subscribe(data => this.appointment = data);
  }

  public deleteAppointById(id:number)
  {
    var ans:boolean=confirm("are you sure you want to delete?");
    if(ans==true)
    {
      this._patientservice.deleteAppointment(id).subscribe(()=>alert("appointment deleted"));

    }

  }


}

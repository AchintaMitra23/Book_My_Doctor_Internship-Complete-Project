import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  id1:number;
  id2:number=0;
    constructor(private route:ActivatedRoute,private router:Router,private admin:AdminService, private loginService : LoginService) {
      this.id1=parseInt(this.route.snapshot.params['id']);
     }
    ngOnInit(): void {
    }

    public logout() {
      this.loginService.logoutUser(this.id1).subscribe(data => {
        if (data == true) {
          alert("Logged Out Successfully");
          this.router.navigate(['form']);
        }
      });
    }

}

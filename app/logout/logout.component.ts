import { Component,OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../authentication-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

    constructor(
      private authenticationService: AuthenticationServiceService,
      private router: Router) {
  
    }
    
    
    
  
      ngOnInit() {
        var status = confirm("Are you sure to Log Out?");
        if (status == true) {
          this.authenticationService.logOut();
          this.router.navigate(['feedback']);
        }
        else{
          this.router.navigate(['softwares']);
        }
      }
}


import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from './authentication-service.service';
// import { AuthenticationService } from './authentication.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{

//   constructor(private router:Router){

//   }
  

//   SoftwareList()
//   {
//     this.router.navigate(['software-list'])
//   }
// ngOninit(){}

constructor(public loginService:AuthenticationServiceService) { }

 }

 



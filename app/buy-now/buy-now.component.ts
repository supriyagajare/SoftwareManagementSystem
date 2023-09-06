import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User';
import { UserService } from '../user.service';
import { Software } from '../software';
import { SoftwareService } from '../software.service';
import { MailServiceService } from '../mail-service.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-buy-now',
  templateUrl: './buy-now.component.html',
  styleUrls: ['./buy-now.component.css']
})
export class BuyNowComponent implements OnInit{
  softwareId: number=0;
  user: User = new User(); 
  formattedDate!: string;
  userEmail: string="";
  software: Software = new Software;






  constructor(private userservice: UserService,private route: ActivatedRoute,
    private router: Router, private emailservice:MailServiceService, private softwareService:SoftwareService) { }

  ngOnInit(): void {
    this.softwareId = this.route.snapshot.params['softwareId'];
    this.formattedDate = this.getFormattedDate();
  }
  AddPurchaseSoftware(){
      this.userservice.addBooking(this.user, this.softwareId).subscribe( data =>{
        console.log(data);
      },
      error => console.log(error));
    }
  
    private getFormattedDate(): string {
      const currentDate = new Date();
      const year = currentDate.getFullYear();
      const month = String(currentDate.getMonth() + 1).padStart(2, '0');
      const day = String(currentDate.getDate()).padStart(2, '0');
      return `${year}-${month}-${day}`;
    }
  
    mailchecking(){
      this.software = new Software();
        this.emailservice.checkEmail(this.user.userEmail, this.software).subscribe(data => {
          console.log(data);
          console.log(this.softwareId);
        },
        error => console.log(error));       
    }


    
  
    onSubmit(){
      this.user.date=this.formattedDate;
      this.AddPurchaseSoftware();
      console.log("add user data to the user table... booking sucesful mail should to gooo");

      console.log(this.user.userEmail);
      if (this.user.userEmail) {
        this.mailchecking();
  
      } else {
        console.log('userEmail is null, cannot make API request.');
      }
    }
}

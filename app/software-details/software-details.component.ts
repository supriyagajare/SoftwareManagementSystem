import { Component , OnInit } from '@angular/core';
import { Software } from '../software';
import { ActivatedRoute } from '@angular/router';
import { SoftwareService } from '../software.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-software-details',
  templateUrl: './software-details.component.html',
  styleUrls: ['./software-details.component.css']
})
export class SoftwareDetailsComponent implements OnInit {


  softwareId: number = 0;
  software: any = [];
  constructor(private route: ActivatedRoute, private softwareService: SoftwareService,private router: Router) { }

  ngOnInit(): void {
    this.softwareId = this.route.snapshot.params['softwareId'];

    this.software = new Software();
    this.softwareService.getSoftwareById(this.softwareId).subscribe( data => {
      this.software = data;
    });
  }



  addBooking(softwareId?:number){
    var status = confirm("Are you going to Buy this Software?");
    if (status == true) {
      this.router.navigate(['buy-now',this.softwareId]);
      }
    
    else{
    console.log("Error in booking")
  }
  }
}

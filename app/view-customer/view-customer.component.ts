import { Component,OnInit,ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {User} from '../User';
import { UserService } from '../user.service';
@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent {
  softwareId: number = 0;
  user: any = [];
  
  constructor(private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private cdRef: ChangeDetectorRef) {

    
    }

  ngOnInit(): void {
    this.softwareId = this.route.snapshot.params['softwareId'];   

    this.user = new User();
    this.userService.getUsersBySoftwareId(this.softwareId).subscribe( data => {
      console.log(data);
      this.user = data;

    });
    
  }
}
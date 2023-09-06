import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DeveloperServiceService } from '../developer-service.service';
import { Developer } from '../developer';

@Component({
  selector: 'app-developer-details',
  templateUrl: './developer-details.component.html',
  styleUrls: ['./developer-details.component.css']
})
export class DeveloperDetailsComponent implements OnInit {

  developerId: number = 0;
  developer: any = [];
  constructor(private route: ActivatedRoute, private developerService: DeveloperServiceService,private router: Router) { }

  ngOnInit(): void {
    this.developerId = this.route.snapshot.params['developerId'];

    this.developer = new Developer();
    this.developerService.getDeveloperById(this.developerId).subscribe( data => {
      this.developer= data;
    });
  }
}

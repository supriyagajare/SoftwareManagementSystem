import { Component, OnInit } from '@angular/core';
import { Developer } from '../developer';
import { Software } from '../software';
import { DeveloperServiceService } from '../developer-service.service';
import { SoftwareService } from '../software.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-get-software',
  templateUrl: './get-software.component.html',
  styleUrls: ['./get-software.component.css']
})
export class GetSoftwareComponent implements OnInit {

  developer: Developer | null = null;
  software: Software | null = null;
  developerId: number = 0;
  softwares: Software[] = [];
  arr: Software[] = [];
  pageNo: number = 1;
  count: number = 5;

  constructor(
    private developerService: DeveloperServiceService,
    private softwareService: SoftwareService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.developerId = this.route.snapshot.params['developerId'];

    if (!isNaN(this.developerId)) { 
      this.software = new Software();

      this.softwareService.getSoftwareByDeveloperId(this.developerId).subscribe(
        (response: Software[] | Software) => {
          if (Array.isArray(response)) {
            this.softwares = response; 
          } else {
            this.softwares = [response]; 
          }
          console.log('Response:', response);
        },
        (error) => {
          console.error('Error:', error);
        }
      );
      
  }
  }
}
import { Component,OnInit } from '@angular/core';
import { Developer } from '../developer';
import { DeveloperServiceService } from '../developer-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-developer',
  templateUrl: './update-developer.component.html',
  styleUrls: ['./update-developer.component.css']
})
export class UpdateDeveloperComponent implements OnInit {

  developerId: number = 0;
  developer: Developer = new Developer();
  constructor(private developerService: DeveloperServiceService,
    private route: ActivatedRoute,
    private router: Router) { }
  ngOnInit(): void {
    this.developerId = this.route.snapshot.params['developerId'];

    this.developerService.getDeveloperById(this.developerId).subscribe(data => {
      this.developer = data;
      console.log(this.developer);
    }, error => console.log(error));
  }
  onSubmit(){
    this.developerService.updateDeveloper(this.developerId, this.developer).subscribe( data =>{
      this.goToDeveloperList();
      
    }
    , error => console.log(error));
  }

  goToDeveloperList(){
    this.router.navigate(['/developers']);
  }
  
 
 
}
import { Component ,OnInit} from '@angular/core';
import { DeveloperServiceService } from '../developer-service.service';
import { Developer } from '../developer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-developer',
  templateUrl: './create-developer.component.html',
  styleUrls: ['./create-developer.component.css']
})
export class CreateDeveloperComponent implements OnInit{
  developer: Developer = new Developer ();
  constructor(private developerService: DeveloperServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  CreateDeveloper(){
    this.developerService.createDeveloper(this.developer).subscribe( data =>{
      console.log(data);
      this.goToDeveloperList();
    },
    error => console.log(error));
  }

  goToDeveloperList(){
    this.router.navigate(['/developers']);
  }
  
  onSubmit(){
    console.log(this.developer);
    this.CreateDeveloper();
  }

}

import { Component,OnInit } from '@angular/core';
import { Developer } from '../developer';
import { DeveloperServiceService } from '../developer-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-developer-list',
  templateUrl: './developer-list.component.html',
  styleUrls: ['./developer-list.component.css']
})
export class DeveloperListComponent implements OnInit {
  developers: Developer[] = [];
  developerName : String = "";
  
  pageNo: number = 1;
  count: number = 5;
  
  constructor(private router: Router ,private developerService: DeveloperServiceService) { }
    ngOnInit(): void {
      this.getDeveloperList();
    }
    private getDeveloperList(){
      this.developerService.getDeveloperList().subscribe(data => {
        
        this.developers = data;
      });
    }

    developerDetails(developerId: number){
      this.router.navigate(['developer-details', developerId]);
    }

    updateDeveloper(developerId: number){
      this.router.navigate(['update-developer', developerId]);
    }


    deleteDeveloper(developerId: number){
      var status = confirm("Are you sure to delete this record?");
      if (status == true) {
      this.developerService.deleteDeveloperById(developerId).subscribe( data => {
        console.log(data);
        this.getDeveloperList();
      })
    }
      else{
        this.getDeveloperList();
 }
}



removeAllDevelopers() : void{
  var status = confirm("Are you sure to delete all the records?");
  if (status == true) {
    this.developerService.deleteAll().subscribe(details => {
      console.log(details);
      this.getDevelopers();
    },
      error => {
        console.log(error);
      })
  }
  else{
  this.getDevelopers();
}
}

private getDevelopers(){
  this.developerService.getDeveloperList().subscribe(data => {
    this.developers = data;

    
  });
}

viewSoftware(developerId: number){
  this.router.navigate(['getSoftware', developerId]);
    }
}
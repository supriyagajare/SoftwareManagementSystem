import { Component ,OnInit} from '@angular/core';
import { Software } from '../software'
import { SoftwareService } from '../software.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-software-list',
  templateUrl: './software-list.component.html',
  styleUrls: ['./software-list.component.css']
})


export class SoftwareListComponent  implements OnInit{


  

  softwares: Software[] = [];
  softwareName : String = "";
  pageNo: number = 1;
  count: number = 5;
  developerName :string="";
  selectedSearchType: string = 'name';




  constructor(private softwareService: SoftwareService,
    private router: Router) { }

  ngOnInit(): void {
    this.getSoftwares();
  }






  
  getIsDesktopApplication() {
    this.softwareService.findByDesktopApplication().subscribe({
      next: (sof) => {
      console.log(sof);
      this.softwares = sof;
    },
    error: (e) => console.error(e)
  });
  }

  getIsWebApplication(){
    this.softwareService.findByWebApplication().subscribe({
      next: (sof) => {
      console.log(sof);
      this.softwares = sof;
    },
    error: (e) => console.error(e)
  });
  }

  removeAllSoftwares() : void{
    var status = confirm("Are you sure to delete all the records?");
    if (status == true) {
      this.softwareService.deleteAllSoftwares().subscribe(details => {
        console.log(details);
        this.getSoftwares();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getSoftwares();
  }
  }

  private getSoftwares(){
    this.softwareService.getSoftwareList().subscribe(data => {
      this.softwares = data;

      
    });
  }

  
  softwareDetails(softwareId: number){
    this.router.navigate(['software-details', softwareId]);
  }

  updateSoftwareDetailsById(softwareId: number){
    this.router.navigate(['update-software', softwareId]);
  }

  deleteSoftwareById(softwareId: number){
    this.softwareService.deleteSoftwareById(softwareId).subscribe( data => {
      console.log(data);
      this.getSoftwares();
    })
  }



  sortBy(sort: string): void {
    switch (sort) {
      case 'costHigh':
        this.softwareService.sortByCost("desc","price").subscribe(details => {
    
          console.log('Response from service:',details);
          this.softwares= details;
    
        },
          error => {
            console.log(error);
          });
        break;
      case 'costLow':
        this.softwareService.sortByCost("asc","price").subscribe(details => {
    
          console.log('Response from service:',details);
          this.softwares= details;
    
        },
          error => {
            console.log(error);
          });
        break;

      case 'ratingLow':
        this.softwareService.sortByRatings("asc","rating").subscribe(details => {
    
          console.log('Response from service:',details);
          this.softwares= details;
    
        },
          error => {
            console.log(error);
          });
          break;
        break;

      case 'ratingHigh':
       this.softwareService.sortByRatings("desc","rating").subscribe(details => {
    
        console.log('Response from service:',details);
        this.softwares= details;
  
      },
        error => {
          console.log(error);
        });
        break;
      default:
        break;
    }
  }







search(selectedSearchType:string) {
  if (this.selectedSearchType === 'name') {
    this.searchBySoftwareName();
  } else if (this.selectedSearchType === 'developerName') {
    this.searchByDeveloperName();
  }
}

searchBySoftwareName() : any{
  this.softwareService.findBySoftwareName(this.softwareName).subscribe(details => {
    this.softwares= details;
    console.log(details);
  },
    error => {
      console.log(error);
    });
}

searchByDeveloperName() {
  console.log('Name to search:', this.developerName);
  
  this.softwareService.findByDeveloperName(this.developerName).subscribe(
    details => {
      console.log('Response from service:', details);
      this.softwares = details;
    },
    error => {
      console.log('Error:', error);
    }
    );
  }



getUsersBySoftwareId(softwareId?: number){
  
  

    // var status = confirm("Are you sure to See this record?");
    // if (status == true) {
    this.router.navigate(['view-user', softwareId]);
    }
    // else{
    //   this.getSoftwares();
    }
 
//   }
// }
  

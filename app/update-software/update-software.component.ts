import { Component ,OnInit} from '@angular/core';
import { Software } from '../software';
import { SoftwareService } from '../software.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-software',
  templateUrl: './update-software.component.html',
  styleUrls: ['./update-software.component.css']
})
export class UpdateSoftwareComponent implements OnInit{

  softwareId: number = 0;
  software: Software = new Software();
  constructor(private softwareService: SoftwareService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.softwareId = this.route.snapshot.params['softwareId'];

    this.softwareService.getSoftwareById(this.softwareId).subscribe(data => {
      this.software = data;
      console.log(this.software);
    }, error => console.log(error));
  }

  onSubmit(){
    this.softwareService.updateSoftwareDetailsById(this.softwareId, this.software).subscribe( data =>{
      this.goToSoftwareList();
    }
    , error => console.log(error));
  }

  goToSoftwareList(){
    this.router.navigate(['/softwares']);
  }
}
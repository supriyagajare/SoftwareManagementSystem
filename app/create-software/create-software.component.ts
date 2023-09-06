import { Component, OnInit } from '@angular/core';
import { Software } from '../software';
import { SoftwareService } from '../software.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-software',
  templateUrl: './create-software.component.html',
  styleUrls: ['./create-software.component.css']
})
export class CreateSoftwareComponent implements OnInit {

  software: Software = new Software();
  constructor(private softwareService: SoftwareService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveSoftware(){
    // console.log("HelloW World")
    this.softwareService.saveSoftware(this.software).subscribe( data =>{
      this.goToSoftwareList();
    },
    error => console.log(error));
  }

  goToSoftwareList(){
    this.router.navigate(['softwares']);
  }
  
  onSubmit(){
    // console.log(this.software);
    this.saveSoftware();
  }
}

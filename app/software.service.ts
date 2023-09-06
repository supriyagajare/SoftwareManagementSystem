import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Software } from './software';

@Injectable({
  providedIn: 'root'
})
export class SoftwareService {

  private baseURL = "http://localhost:8080/api/v1/software";

  constructor(private httpClient: HttpClient) { }


  getAllSoftwares(): Observable<Software[]>{
    return this.httpClient.get<Software[]>(`${this.baseURL}`);
  }

  getSoftwareList(): Observable<Software[]>{
    return this.httpClient.get<Software[]>(`${this.baseURL}`);
  }

  findBySoftwareName(softwareName:any):Observable<Software[]>{
    return this.httpClient.get<Software[]>(`${this.baseURL}?name=${softwareName}`);
  }

  saveSoftware(software: Software): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, software);
  }

  getSoftwareById(softwareId: number): Observable<Software>{
    return this.httpClient.get<Software>(`${this.baseURL}/getSoftware/${softwareId}`);
  }

  updateSoftwareDetailsById(softwareId: number, software: Software): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${softwareId}`, software);
  }

  deleteSoftwareById(softwareId: number): Observable<Object>{  //2
    return this.httpClient.delete(`${this.baseURL}/${softwareId}`);
  }

  deleteAllSoftwares(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}`);
  }


  findByDesktopApplication(): Observable<Software[]> {
    console.log(" Is DesktopApplication");
    return this.httpClient.get<Software[]>(`${this.baseURL}/isDesktopSoftware`);
  }

  findByWebApplication(): Observable<Software[]> {
    console.log("Is WebApplication");
    return this.httpClient.get<Software[]>(`${this.baseURL}/isWebApplicationSoftware`);
}

findByDeveloperName(developerName: string): Observable<Software[]> {
  // Encode the developerName parameter
  const encodedDeveloperName = encodeURIComponent(developerName);

  return this.httpClient.get<Software[]>(`${this.baseURL}/searchByDevName?developerName=${encodedDeveloperName}`);
}

sortByRatings(pathVar : string,fieldName : string): Observable<Software[]> {
  return this.httpClient.get<Software[]>(`${this.baseURL}/filter/Rating/${pathVar}?rating=${fieldName}`); 
 }


sortByCost(pathVar : string, fieldName : string): Observable<Software[]> {
  return this.httpClient.get<Software[]>(`${this.baseURL}/filter/Price/${pathVar}?price=${fieldName}`); 
}


getSoftwareByDeveloperId(id: number): Observable<Software>{
  return this.httpClient.get<Software>(`${this.baseURL}/byDeveloper/${id}`);
  }
}

  
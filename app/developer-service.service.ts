import { Injectable } from '@angular/core';
import { Developer } from './developer';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DeveloperServiceService {


  private baseURL = "http://localhost:8080/developer";

  constructor(private httpClient: HttpClient) { }

  getAllDeveloper(): Observable<Developer[]>{
    return this.httpClient.get<Developer[]>(`${this.baseURL}`);
  }
  
  getDeveloperList(): Observable<Developer[]>{
    return this.httpClient.get<Developer[]>(`${this.baseURL}`);
  }

  createDeveloper(developer: Developer): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, developer);
  }

  
  getDeveloperById(developerId: number): Observable<Developer>{
    console.log("in developer serv"+developerId)
    return this.httpClient.get<Developer>(`${this.baseURL}/${developerId}`);
    
  }
  updateDeveloper(developerId: number, developer: Developer) : Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateDeveloper/${developerId}`, developer);
  }

  deleteDeveloperById(developerId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteDeveloper/${developerId}`);
  }

deleteAll(): Observable<any> {
  return this.httpClient.delete(`${this.baseURL}`);
}
}

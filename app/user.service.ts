import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './User';
import { map } from 'rxjs/operators';
import { Software } from './software';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8080/users";
  
  constructor(private httpClient: HttpClient) { }

  getUsersBySoftwareId(softwareId?: number): Observable<User>{
  return this.httpClient.get<User>(`${this.baseURL}/softwareUsers/${softwareId}`);
}
  

addBooking(user: User, softwareId?: number): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}/softwareTable/${softwareId}`,user);
}
}

import { Injectable } from '@angular/core';
import { Software } from './software';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
  providedIn: 'root'
})
export class MailServiceService {

  private baseURL = "http://localhost:8080/email/";
  constructor(private httpClient: HttpClient) { };

  checkEmail(mail:string,software:Software):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}?userEmail=${mail}`,software);
}
}


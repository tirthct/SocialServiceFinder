import { Injectable } from '@angular/core';
import { Login } from '../../models/Login';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

const httpOptions = {
  header: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  private apiServerUrlUser = environment.baseUrlUser;
  private apiServerUrlOrg = environment.baseUrlOrg;

  constructor(private http: HttpClient) { }

  public loginUser(login: Login): Observable<Login>{
    console.log("Sending Login Info to Userservice");
    console.log(login.email);
    return this.http.post<Login>(`${this.apiServerUrlUser}/user/login`,login);
  }

  public loginOrganiser(login: Login): Observable<Login>{
    console.log("Sending Login Info to Organisationservice");
    console.log(login.email);
    return this.http.post<Login>(`${this.apiServerUrlOrg}/organization/login`,login);
  }
  
}

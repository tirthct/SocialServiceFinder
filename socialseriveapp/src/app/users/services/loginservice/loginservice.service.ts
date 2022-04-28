import { Injectable } from '@angular/core';
import { Login } from '../../models/Login';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Organiser } from '../../models/Organiser';
import { User } from '../../models/user';

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

  public loginUser(login: Login): Observable<User>{
    return this.http.post<User>(`${this.apiServerUrlUser}/user/login`,login);
  }

  public loginOrganiser(login: Login): Observable<Organiser>{
    return this.http.post<Organiser>(`${this.apiServerUrlOrg}/organization/login`,login);
  }
  
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { User } from '../../models/user';

const httpOptions = {
  header: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})

export class UserregistrationService {

  private apiServerUrlUser = environment.baseUrlUser;
  private apiServerUrlOrg = environment.baseUrlOrg;
  constructor(private http: HttpClient) { }

  public getUser(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiServerUrlUser}/user`);
  }

  public addUser(User: User): Observable<User> {
    console.log("Sending User POST");
    console.log(User);
    return this.http.post<User>(`${this.apiServerUrlUser}/user`, User);
  }
}

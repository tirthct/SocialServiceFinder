import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../models/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UserregistrationService {

  private apiServerUrl = environment.baseUrl;
  constructor(private http: HttpClient){ }

  public getUser(): Observable<User[]>{
    return this.http.get<User[]>(`${this.apiServerUrl}/user`);
  }

  public addUser(User: User): Observable<User>{
    return this.http.post<User>(`${this.apiServerUrl}/addUser`, User);
  }
}

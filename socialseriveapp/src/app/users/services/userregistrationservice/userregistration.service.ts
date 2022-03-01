import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../models/user';
import { UserOrg } from '../../models/userOrg';
import { environment } from 'src/environments/environment';

const httpOptions = {
  header: new HttpHeaders({
    'Content-Type':  'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})

export class UserregistrationService {

  private apiServerUrlUser = environment.baseUrlUser;
  private apiServerUrlOrg = environment.baseUrlOrg;
  constructor(private http: HttpClient){ }

  public getUser(): Observable<User[]>{
    return this.http.get<User[]>(`${this.apiServerUrlUser}/user`);
  }

  public getUserOrg(): Observable<UserOrg[]>{
    return this.http.get<UserOrg[]>(`${this.apiServerUrlOrg}/organization`);
  }

  public addUser(User: User): Observable<User>{
    console.log("Sending User POST");
    console.log(User);
    return this.http.post<User>(`${this.apiServerUrlUser}/user`, User);
  }

  public addUserOrg(UserOrg: UserOrg): Observable<UserOrg>{
    console.log("Sending UserOrg POST");
    console.log(UserOrg);
    return this.http.post<UserOrg>(`${this.apiServerUrlOrg}/organization`, UserOrg);
  }

}

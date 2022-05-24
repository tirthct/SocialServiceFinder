import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Organiser } from '../../models/Organiser';
import { environment } from 'src/environments/environment';
import { User } from '../../models/User';

const httpOptions = {
  header: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})

export class UpdateProfileService {

  constructor(private http: HttpClient) { }

  private apiServerUrlOrg = environment.baseUrlOrg;
  private apiServerUrlUser = environment.baseUrlUser;

  public getOrganiser(): Observable<Organiser[]> {
    return this.http.get<Organiser[]>(`${this.apiServerUrlOrg}/organization`);
  }

  public updateUserProfile(User: User): Observable<User> {
    return this.http.post<User>(`${this.apiServerUrlUser}/user/update/`, User);
  }

  public updateOrganiserService(organiser: Organiser): Observable<Organiser> {
    return this.http.post<Organiser>(`${this.apiServerUrlOrg}/organization/update/`, organiser);
  }
}

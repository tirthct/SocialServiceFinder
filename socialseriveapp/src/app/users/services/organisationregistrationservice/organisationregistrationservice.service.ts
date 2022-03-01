import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Organiser } from '../../models/Organiser';
import { environment } from 'src/environments/environment';

const httpOptions = {
  header: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})
export class OrganisationregistrationserviceService {

  constructor(private http: HttpClient) { }

  private apiServerUrlOrg = environment.baseUrlOrg;

  public getOrganiser(): Observable<Organiser[]> {
    return this.http.get<Organiser[]>(`${this.apiServerUrlOrg}/organization`);
  }

  public addOrganiser(organiser: Organiser): Observable<Organiser> {
    return this.http.post<Organiser>(`${this.apiServerUrlOrg}/organization`, organiser);
  }
}

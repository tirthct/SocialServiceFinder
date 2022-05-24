import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class EventDeleteServiceService {

  private apiServerUrlEvent = environment.baseUrlEventPage;
  private apiServerUrlUser = environment.baseUrlEvent;

  constructor(private http: HttpClient) { }

  public deleteEvent(event: any): Observable<String>{
    return this.http.post<String>(`${this.apiServerUrlUser}/event/delete/`,event);
  }
}

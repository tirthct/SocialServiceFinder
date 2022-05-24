import { Injectable } from '@angular/core';
import { EventRegistration } from '../../models/EventRegistration'; 
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventregistrationserviceService {

  private apiServerUrlEvent = environment.baseUrlEventPage;
  private apiServerUrlUser = environment.baseUrlEvent;

  constructor(private http: HttpClient) { }

  public registerForEvent(eventRegistrationObject: EventRegistration): Observable<String>{
    return this.http.post<String>(`${this.apiServerUrlUser}/event/registerForEvent`,eventRegistrationObject);
  }
}
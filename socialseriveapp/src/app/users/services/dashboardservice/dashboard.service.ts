import { Injectable } from '@angular/core';
import { UserregistrationService } from '../userregistrationservice/userregistration.service';
import { User } from '../../models/User';
import { Organiser } from '../../models/Organiser';
import { Observable } from 'rxjs';
import { Event } from '../../models/Event';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { SearchQuery } from '../../models/SearchQuery';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  private user!: User;
  public isUser!: boolean; 
  private organisation!: Organiser;
  private apiServerUrlUser = environment.baseUrlEvent;
  constructor(private http: HttpClient) { }

  public setUser(user :User){
    this.user = JSON.parse(localStorage.getItem('userDetails') || '{}');
    this.isUser = JSON.parse(localStorage.getItem('status') || '{}');
    console.log(this.user);
  }

  public setOrgniser(organiser :Organiser){
    this.organisation = organiser;
    this.isUser = false;
  }

  public getUser():User{
    return this.user;
  }

  public getOrganiser():Organiser{
    return this.organisation;
  }

  public createEvent(Event: Event): Observable<Event>{
    var url=`${this.apiServerUrlUser}/event`;
    return this.http.post<Event>(url, Event);
  }

  public searchEvents(SearchQuery: SearchQuery): Observable<SearchQuery>{
    var url=`${this.apiServerUrlUser}/event/search/`;
    return this.http.post<SearchQuery>(url, SearchQuery);
  }
}

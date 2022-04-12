import { Injectable } from '@angular/core';
import { UserregistrationService } from '../userregistrationservice/userregistration.service';
import { User } from '../../models/User';
import { Organiser } from '../../models/Organiser';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  private user!: User;
  public isUser!: boolean; 
  private organisation!: Organiser;

  constructor() { }

  public setUser(user :User){
    this.user = user;
    this.isUser = true;
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
}

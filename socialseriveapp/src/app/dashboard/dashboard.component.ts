import { Component, OnInit } from '@angular/core';
import { CreateEvent } from '../users/models/CreateEvent';
import { Organiser } from '../users/models/Organiser';
import { User } from '../users/models/User';
import { DashboardService } from '../users/services/dashboardservice/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user!: User;
  isUser!: boolean;
  organisation!: Organiser;
  panelOpenState = false;
  createEventObject!: CreateEvent;
  createEventFormPanelOpenState = false;
  eventName: string="";
  eventDescription: string="";
  eventRewards: string="";
  eventLocation: string="";
  eventPOCName: string="";
  eventPOCContact: string="";
  eventPOCEmail: string="";
  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    this.isUser = this.dashboardService.isUser;
    if(this.isUser)
      this.user = this.dashboardService.getUser();
    else
      this.organisation = this.dashboardService.getOrganiser();
  }

  createEvent(): void{
    this.createEventObject ={
      eventName: this.eventName,
      eventDescription: this.eventDescription,
      eventRewards: Number(this.eventRewards),
      eventLocation: this.eventLocation,
      eventPOCName: this.eventPOCName,
      eventPOCContact: Number(this.eventPOCContact),
      eventPOCEmail: this.eventPOCEmail
    }

    console.log(this.createEventObject);


    //TO DO: call the backend service using this object
  }
}
import { Component, OnInit } from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { Event } from '../users/models/Event';
import {FetchMyEvents} from '../users/models/FetchMyEvents'
import { Organiser } from '../users/models/Organiser';
import { SearchQuery } from '../users/models/SearchQuery';
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
  createEventObject!: Event;
  createEventFormPanelOpenState = false;
  eventName: string="";
  eventDescription: string="";
  eventRewards: string="";
  eventLocation: string="";
  eventPOCName: string="";
  eventPOCContact: string="";
  eventPOCEmail: string="";
  eventCity: string="";
  eventZip: string="";
  searchEventsQuery: string="";
  eventResult! : any[];
  searchQueryObject!:SearchQuery;
  startDate!: Date;
  endDate!: Date;
  eventReturn: string="";
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  events!: Event;
  id: string="";
  fetchMyEventsObject!:FetchMyEvents;
  constructor(private dashboardService: DashboardService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.isUser = JSON.parse(localStorage.getItem('status') || '{}');
    if(this.isUser){
      this.user = JSON.parse(localStorage.getItem('userDetails') || '{}');
      console.log(this.user);
      this.id=JSON.parse(localStorage.getItem('userDetails') || '{}').id;
      console.log(this.user);
    }else{
      this.organisation = JSON.parse(localStorage.getItem('orgDetails') || '{}');
      this.id=JSON.parse(localStorage.getItem('orgDetails') || '{}').id;
    }
  }

  createEvent(): void{
    this.createEventObject ={
      name: this.eventName,
      description: this.eventDescription,
      rewards: Number(this.eventRewards),
      address: this.eventLocation,
      POCName: this.eventPOCName,
      phoneNo: Number(this.eventPOCContact),
      email: this.eventPOCEmail,
      city: this.eventCity,
      pinCode: Number(this.eventZip),
      startDate: this.startDate,
      endDate: this.endDate,
      organizationId: this.id
    }

    console.log(this.createEventObject);
    
    this.dashboardService.createEvent(this.createEventObject).subscribe((res)=>{
      this._snackBar.open('Event Created!!', "",{
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
        duration: 2000,
      });
      this.clearForm();
    },
    (err)=>{
      this._snackBar.open('Failure: In Event Creation!!', "",{
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
        duration: 2000,
      });
    }
    )
  }

  getEventData(event: any): void{
    localStorage.setItem("currEvent", JSON.stringify(event));
  }


  searchEvents(): void{
    this.searchQueryObject={
      query: this.searchEventsQuery
    }

    console.log(this.searchQueryObject);
    this.dashboardService.searchEvents(this.searchQueryObject).subscribe((res)=>{
      this.eventReturn = JSON.stringify(res);
      this.eventResult=JSON.parse(this.eventReturn);
      this.searchEventsQuery="";
    },(err)=>{
      this.searchEventsQuery="";
      this._snackBar.open('Search Fetch Failed!!', "",{
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
        duration: 2000,
      });
    });
  }

  clearForm(): void{
    this.eventName="";
    this.eventDescription="";
    this.eventRewards="";
    this.eventLocation="";
    this.eventPOCName="";
    this.eventPOCContact="";
    this.eventPOCEmail="";
    this.eventCity="";
    this.eventZip="";
  }

  fetchMyEvents(): void{
    this.fetchMyEventsObject={
      id: this.id,
      isOrganizer: !this.isUser
    }
    this.dashboardService.fetchMyEvents(this.fetchMyEventsObject).subscribe((res)=>{
      console.log(res);
    }, (err)=>{
      this._snackBar.open('My Events Fetch Failed!!', "",{
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
        duration: 2000,
      });
    });
  }

  isNumber(contact: any): boolean {
    return !isNaN(contact);
  }
}
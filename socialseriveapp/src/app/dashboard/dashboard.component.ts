import { Component, OnInit } from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { Event } from '../users/models/Event';
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
  eventResult: string="";
  searchQueryObject!:SearchQuery;
  startDate!: Date;
  endDate!: Date;
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  events!: Event;
  constructor(private dashboardService: DashboardService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.isUser = JSON.parse(localStorage.getItem('status') || '{}');
    if(this.isUser)
    this.user = JSON.parse(localStorage.getItem('userDetails') || '{}');
    else
    this.organisation = JSON.parse(localStorage.getItem('orgDetails') || '{}');
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
      endDate: this.endDate
    }

    console.log(this.createEventObject);
    
    this.dashboardService.createEvent(this.createEventObject).subscribe((res)=>{
      this._snackBar.open('Event Created!!', "",{
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
        duration: 2000,
      });
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

  searchEvents(): void{
    this.searchQueryObject={
      query: this.searchEventsQuery
    }
    console.log(this.searchQueryObject);
    this.dashboardService.searchEvents(this.searchQueryObject).subscribe((res)=>{
      this.eventResult=JSON.stringify(res);
      console.log(res);
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

  isNumber(contact: any): boolean {
    return !isNaN(contact);
  }
}
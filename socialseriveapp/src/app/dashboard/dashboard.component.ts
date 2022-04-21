import { Component, OnInit } from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { Event } from '../users/models/Event';
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
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  constructor(private dashboardService: DashboardService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.isUser = this.dashboardService.isUser;
    if(this.isUser)
      this.user = this.dashboardService.getUser();
    else
      this.organisation = this.dashboardService.getOrganiser();
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
      pinCode: Number(this.eventZip)
    }
    
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
}
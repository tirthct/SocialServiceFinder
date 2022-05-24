import { Component, OnInit } from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { EventRegistration } from '../users/models/EventRegistration';
import { EventregistrationserviceService } from '../users/services/eventregistationservice/event-registration-service.service';
import { Router } from '@angular/router';
import {EventDeleteServiceService} from '../users/services/eventdeletionservice/event-delete-service.service';

@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {
  event!: any;
  eventId: string="";
  userId: string="";
  isUser!: boolean;
  myEvent!: boolean;
  eventRegistrationObject!: EventRegistration;
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(private eventRegisterService:EventregistrationserviceService,private _snackBar: MatSnackBar, private router: Router,
              private eventDeletionService: EventDeleteServiceService) { }

  ngOnInit(): void {
    this.event = JSON.parse(localStorage.getItem('currEvent') || '{}');
    this.eventId = JSON.parse(localStorage.getItem('currEvent') || '{}').id;
    this.userId = JSON.parse(localStorage.getItem('userDetails') || '{}').id;
    this.isUser = JSON.parse(localStorage.getItem('status') || '{}');
    this.myEvent = JSON.parse(localStorage.getItem('myEvent') || '{}');
    console.log(this.event);
  }

  registerEvent(): void{
    //console.log(this.event);
      this.eventRegistrationObject = {
        userId: this.userId,
        eventId: this.eventId
      }
      console.log(this.eventRegistrationObject);
      this.eventRegisterService.registerForEvent(this.eventRegistrationObject).subscribe((res)=>{
        this._snackBar.open('Registration Successful!!', "",{
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
          duration: 2000,
        })
        console.log(res);
        this.router.navigateByUrl("/dashboard")
      },
      (err)=>{
        this._snackBar.open('Registartion Failed!!', "",{
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
          duration: 2000,
        });
      });
  }

  deleteEvent(): void{
    this.event.deleted = true;
    console.log(this.event);
    this.eventDeletionService.deleteEvent(this.event).subscribe((res)=>{
      this._snackBar.open('Deletion Successful!!', "",{
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
        duration: 2000,
      })
      console.log(res);
      this.router.navigateByUrl("/dashboard")
    },
    (err)=>{
      this._snackBar.open('Deletion Failed!!', "",{
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
        duration: 2000,
      });
    });

  }
}

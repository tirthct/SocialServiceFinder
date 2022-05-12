import { Component, OnInit } from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { Event } from '../users/models/Event';
import { FetchMyEvents } from '../users/models/FetchMyEvents';
import { Organiser } from '../users/models/Organiser';
import { SearchQuery } from '../users/models/SearchQuery';
import { User } from '../users/models/User';
import { DashboardService } from '../users/services/dashboardservice/dashboard.service';


@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {
  event!: any;

  constructor(private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.event = JSON.parse(localStorage.getItem('currEvent') || '{}');
    console.log(this.event);
  }

  registerEvent(): void{
    console.log(this.event);
  }

}

import { Component, OnInit } from '@angular/core';
import { ContactUs } from 'src/app/users/models/ContactUs';
import { DashboardService } from 'src/app/users/services/dashboardservice/dashboard.service';
import { LoginserviceService } from 'src/app/users/services/loginservice/loginservice.service';
import { Router } from '@angular/router';

import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent implements OnInit {
  
  constructor() { }
  ngOnInit(): void {
  }
}

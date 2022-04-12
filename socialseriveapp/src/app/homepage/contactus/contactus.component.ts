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
  email : string = "";
  contactNumber : string = ""; 
  contactUsObject!: ContactUs;
  message : string = "";
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(private loginserviceService: LoginserviceService, 
    private dashboardService: DashboardService,
    private router: Router,
    private _snackBar: MatSnackBar) { }

  contactUs() : void {
    console.log("Reached here");
  }

  ngOnInit(): void {
  }
}

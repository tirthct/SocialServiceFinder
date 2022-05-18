import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../users/models/Login';
import { DashboardService } from '../users/services/dashboardservice/dashboard.service';
import { LoginserviceService } from '../users/services/loginservice/loginservice.service';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

@Component({
    selector: 'app-update-profile',
    templateUrl: './update-profile.component.html',
    styleUrls: ['./update-profile.component.css']
  })

export class UpdateProfileComponent implements OnInit{
    ngOnInit(): void {
    }
}
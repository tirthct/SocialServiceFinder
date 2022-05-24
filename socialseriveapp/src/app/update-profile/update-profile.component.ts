import { Component, OnInit } from '@angular/core';
import { User } from '../users/models/User';
import { Organiser } from '../users/models/Organiser';
import { UpdateProfileService } from '../users/services/updateprofileservice/updateprofileservice.service';
// import { DashboardService } from '../users/services/dashboardservice/dashboard.service';
// import { DashboardComponent } from '../dashboard/dashboard.component';
import { Router } from '@angular/router';

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
    name: string = "";
    phNo: string = "";
    addr: string = "";
    city: string = "";
    password: string = "";
    cPassword: string = "";
    pincode: string="";
    user!: User;
    organiser!: Organiser;
    isUser!: boolean;
    horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    verticalPosition: MatSnackBarVerticalPosition = 'top';

    constructor(private updateProfileService: UpdateProfileService,
      private router: Router,
      private _snackBar: MatSnackBar) {
    }

    ngOnInit(): void {
      this.isUser=JSON.parse(localStorage.getItem("status") || '{}');
      console.log(this.isUser);
      if(this.isUser){
        this.user=JSON.parse(localStorage.getItem("userDetails")|| '{}');
        console.log(this.user);
      }else{
        this.organiser=JSON.parse(localStorage.getItem("orgDetails")|| '{}');
        console.log(this.organiser);
      }
    }

    isNumber(pincode: any): boolean {
      return !isNaN(pincode);
    }

    updateDetails():void{
      if(this.name!=null && this.name.length>0){
        if(this.isUser){
          this.user.name=this.name;
        }else{
          this.organiser.name=this.name;
        }
      }

      if(this.phNo!=null && this.phNo.length>0){
        if(this.isUser){
          this.user.phoneNo=this.phNo;
        }else{
          this.organiser.phoneNo=this.phNo;
        }
      }


      if(this.addr!=null && this.addr.length>0){
        if(this.isUser){
          this.user.address=this.addr;
        }else{
          this.organiser.address=this.addr;
        }
      }

      if(this.city!=null && this.city.length>0){
        if(this.isUser){
          this.user.city=this.city;
        }else{
          this.organiser.city=this.city;
        }
      }

      if(this.pincode!=null && this.pincode.length>0){
        if(this.isUser){
          this.user.pinCode=Number(this.pincode);
        }else{
          this.organiser.pinCode=Number(this.pincode);
        }
      }

      if(this.password!=null && this.password.length>0){
        if(this.isUser){
          this.user.password=this.password;
        }else{
          this.organiser.password=this.password;
        }
      }else{
        if(this.isUser){
          this.user.password="";
        }else{
          this.organiser.password="";
        }
      }

      console.log("Sending this to the update Organiser");
      console.log(this.organiser);

      if(this.isUser){
        this.updateProfileService.updateUserProfile(this.user).subscribe((res)=>{
          console.log("User Update Successful");
          this._snackBar.open('User Update successful!!', "",{
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            duration: 2000,
          });
          localStorage.clear();
          this.router.navigateByUrl("/").then(() => {
            window.location.reload();
          });
        },
        (err)=>{
          this._snackBar.open('User Update Failed!!', "",{
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            duration: 2000,
          });
        });
      }else{
        this.updateProfileService.updateOrganiserService(this.organiser).subscribe((res)=>{
          console.log("Organiser Update Successful");
          this._snackBar.open('Organiser Update successful!!', "",{
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            duration: 2000,
          });
          localStorage.clear();
          this.router.navigateByUrl("/").then(() => {
            window.location.reload();
          });
        },
        (err)=>{
          this._snackBar.open('Organiser Update Failed!!', "",{
            horizontalPosition: this.horizontalPosition,
            verticalPosition: this.verticalPosition,
            duration: 2000,
          });
        });
      }
    }
}
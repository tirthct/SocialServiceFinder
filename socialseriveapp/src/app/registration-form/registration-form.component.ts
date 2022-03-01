import { Component, OnInit } from '@angular/core';

import { User } from '../users/models/user';
import { UserOrg } from '../users/models/userOrg';
import { Router } from '@angular/router';

import { UserregistrationService } from '../users/services/userregistrationservice/userregistration.service';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  userType: string="User";
  currDate: Date = new Date;
  options: string[] = ['User', 'Organiser'];
  orgTypes: string[] = ['orphanage', 'oldage', 'environmental'];
  fName: string="";
  lName: string="";
  phNo: string="";
  dob!: Date;
  addr: string="";
  city: string="";
  state: string="";
  pincode: string="";
  email: string="";
  prefs: string[]=[];
  orgTypeChosen: string="";
  password: string="";
  cPassword: string="";

  user!: User;
  userOrg!: UserOrg;
  newusers: User[]=[];
  emailFormat = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
 
  constructor(private userRegistrationService: UserregistrationService, private router: Router) {
    
   }

  ngOnInit(): void {
    //this.userRegistrationService.getUser().subscribe((newusers)=> (this.newusers = User));
  }

  onRegister(): void{
    if(this.userType=="User"){
      this.user = {
        name: `${this.fName} ${this.lName}`,
        email: this.email,
        dob: this.dob,
        phoneNo: this.phNo,
        address: `${this.addr}, ${this.city}, ${this.state}, ${this.pincode}`,
        city: this.city,
        pinCode: Number(this.pincode),
        preferences: this.prefs,
      }
      this.userRegistrationService.addUser(this.user).subscribe();
      this.router.navigateByUrl('/login');
    }
    else if(this.userType=="Organiser"){
      this.userOrg = {
        name: `${this.fName} ${this.lName}`,
        email: this.email,
        dob: this.dob,
        phoneNo: this.phNo,
        address: `${this.addr}, ${this.city}, ${this.state}, ${this.pincode}`,
        city: this.city,
        pinCode: Number(this.pincode),
        organization_type: this.orgTypeChosen,
      }
      this.userRegistrationService.addUserOrg(this.userOrg).subscribe();
      this.router.navigateByUrl('/login');
    }
  }

  isNumber(pincode: any): boolean{
    return !isNaN(pincode);
  }
}



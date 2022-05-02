import { Component, OnInit } from '@angular/core';
import { User } from '../../users/models/User';
import { Organiser } from '../../users/models/Organiser';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loginStatus: string="";
  isUser!: boolean;
  user!: User; 
  
  constructor() { }

  ngOnInit(): void {
    this.loginStatus=JSON.parse(localStorage.getItem('loginStatus') || "");
  }

  logout(): void{
    this.loginStatus="";
    localStorage.clear();
    console.log("Bye..");
  }

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loginStatus: string="";
  
  constructor() { }

  ngOnInit(): void {
    this.loginStatus=JSON.parse(localStorage.getItem('loginStatus') || "");
  }

  logout(): void{
    this.loginStatus="";
    localStorage.clear();
  }

}

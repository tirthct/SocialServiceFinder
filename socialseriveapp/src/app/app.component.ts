import { Component, OnInit } from '@angular/core';
import { UserregistrationService } from './userregistration.service';
import { User } from './user';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

//Implementing OnInit will call ngOnInit function when the component is initialized.
export class AppComponent implements OnInit{
  title = 'socialseriveapp';
  public users: User[];

  constructor(private userRegistrationService: UserregistrationService){
    this.users = [];
  }

  ngOnInit(): void {
      this.getUsers();
  }

  public getUsers(): void {
    this.userRegistrationService.getUser().subscribe({
      next: (response: User[]) => { this.users = response },
      error: (error: HttpErrorResponse) => { console.log(error.message) }
    });
  }
}

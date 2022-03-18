import { Component, OnInit } from '@angular/core';
import { Login } from '../users/models/Login';
import { LoginserviceService } from '../users/services/loginservice/loginservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email : string = "";
  password : string = ""; 
  loginObject!: Login;
  userType: string = "User";
  options: string[] = ['User', 'Organiser'];

  constructor(private loginserviceService: LoginserviceService) { }

  ngOnInit(): void {
  }
  
  login(): void {
    console.log("Login");

    this.loginObject = {
      email: this.email,
      password: this.password
    }

    if(this.userType == "User"){
      this.loginserviceService.loginUser(this.loginObject);
    }
    else if(this.userType == "Organiser"){
      this.loginserviceService.loginOrganiser(this.loginObject);
    }
    else{
      console.log("No valid userType selected.");
    }
  }
}

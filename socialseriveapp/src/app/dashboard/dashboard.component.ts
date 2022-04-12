import { Component, OnInit } from '@angular/core';
import { Organiser } from '../users/models/Organiser';
import { User } from '../users/models/User';
import { DashboardService } from '../users/services/dashboardservice/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user!: User;
  isUser!: boolean;
  organisation!: Organiser;
  panelOpenState = false;
  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    this.isUser = this.dashboardService.isUser;
    if(this.isUser)
      this.user = this.dashboardService.getUser();
    else
      this.organisation = this.dashboardService.getOrganiser();
  }

}

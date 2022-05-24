import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ContactusComponent } from "./homepage/contactus/contactus.component";
import { HomepageComponent } from "./homepage/homepage.component";
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from "./dashboard/dashboard.component";
import {EventPageComponent} from "./event-page/event-page.component";
import { UpdateProfileComponent } from "./update-profile/update-profile.component";

const routes: Routes = [
    { path: '', component: HomepageComponent },
    { path: 'register', component: RegistrationFormComponent },
    { path: 'contact', component: ContactusComponent },
    { path: 'login', component: LoginComponent },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'eventPage', component: EventPageComponent },
    {path: 'updateProfile', component: UpdateProfileComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
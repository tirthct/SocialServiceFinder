import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ContactusComponent } from "./homepage/contactus/contactus.component";
import { HomepageComponent } from "./homepage/homepage.component";
import { RegistrationFormComponent } from './registration-form/registration-form.component';

const routes: Routes = [
    {path: '', component: HomepageComponent},
    { path: 'register', component: RegistrationFormComponent},
    { path: 'contact', component: ContactusComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}
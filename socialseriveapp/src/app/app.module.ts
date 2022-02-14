import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { UserregistrationService } from './users/services/userregistrationservice/userregistration.service';
import { RegistrationFormComponent } from './registration-form/registration-form.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [UserregistrationService],
  bootstrap: [AppComponent]
})
export class AppModule { }

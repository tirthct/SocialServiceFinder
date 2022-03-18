import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarComponent } from './navbar.component';
import { RegistrationFormComponent } from 'src/app/registration-form/registration-form.component';
import { HomepageComponent } from 'src/app/homepage/homepage.component';
import { ContactusComponent } from 'src/app/homepage/contactus/contactus.component';

describe('NavbarComponent', () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should navigate to register component', () => {
    let registerBtn = fixture.debugElement.nativeElement.querySelector("#registerBtn");
    registerBtn.click();
    expect(RegistrationFormComponent).toBeDefined();
  });

  it('should navigate to home component', () => {
    let registerBtn = fixture.debugElement.nativeElement.querySelector("#homeBtn");
    registerBtn.click();
    expect(HomepageComponent).toBeDefined();
  });

  it('should navigate to contactus component', () => {
    let registerBtn = fixture.debugElement.nativeElement.querySelector("#contactusBtn");
    registerBtn.click();
    expect(ContactusComponent).toBeDefined();
  });
});



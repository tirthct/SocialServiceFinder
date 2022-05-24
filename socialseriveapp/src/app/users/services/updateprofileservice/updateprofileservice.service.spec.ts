import { TestBed } from '@angular/core/testing';


import { UpdateProfileService } from './updateprofileservice.service';

describe('OrganisationregistrationserviceService', () => {
  let service: UpdateProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

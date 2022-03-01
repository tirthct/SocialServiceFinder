import { TestBed } from '@angular/core/testing';

import { OrganisationregistrationserviceService } from './organisationregistrationservice.service';

describe('OrganisationregistrationserviceService', () => {
  let service: OrganisationregistrationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganisationregistrationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

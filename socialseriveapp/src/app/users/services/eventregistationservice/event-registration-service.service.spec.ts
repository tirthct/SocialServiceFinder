import { TestBed } from '@angular/core/testing';

import { EventregistrationserviceService } from './event-registration-service.service';

describe('EventRegistrationServiceService', () => {
  let service: EventregistrationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventregistrationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

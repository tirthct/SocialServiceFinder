import { TestBed } from '@angular/core/testing';

import { EventDeleteServiceService } from './event-delete-service.service';

describe('EventDeleteServiceService', () => {
  let service: EventDeleteServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventDeleteServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

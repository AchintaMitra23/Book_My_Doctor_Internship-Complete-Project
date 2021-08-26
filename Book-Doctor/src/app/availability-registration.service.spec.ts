import { TestBed } from '@angular/core/testing';

import { AvailabilityRegistrationService } from './availability-registration.service';

describe('AvailabilityRegistrationService', () => {
  let service: AvailabilityRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AvailabilityRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

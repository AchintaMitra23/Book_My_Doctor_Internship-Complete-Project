import { TestBed } from '@angular/core/testing';

import { FeedbackRegistrationService } from './feedback-registration.service';

describe('FeedbackRegistrationService', () => {
  let service: FeedbackRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeedbackRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

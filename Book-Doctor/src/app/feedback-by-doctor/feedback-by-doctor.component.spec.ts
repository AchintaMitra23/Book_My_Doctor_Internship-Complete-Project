import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackByDoctorComponent } from './feedback-by-doctor.component';

describe('FeedbackByDoctorComponent', () => {
  let component: FeedbackByDoctorComponent;
  let fixture: ComponentFixture<FeedbackByDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedbackByDoctorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackByDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackByIdComponent } from './feedback-by-id.component';

describe('FeedbackByIdComponent', () => {
  let component: FeedbackByIdComponent;
  let fixture: ComponentFixture<FeedbackByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedbackByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

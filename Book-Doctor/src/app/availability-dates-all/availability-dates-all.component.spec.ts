import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailabilityDatesAllComponent } from './availability-dates-all.component';

describe('AvailabilityDatesAllComponent', () => {
  let component: AvailabilityDatesAllComponent;
  let fixture: ComponentFixture<AvailabilityDatesAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailabilityDatesAllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailabilityDatesAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

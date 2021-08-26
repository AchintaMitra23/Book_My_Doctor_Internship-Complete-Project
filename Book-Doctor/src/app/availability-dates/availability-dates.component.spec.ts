import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailabilityDatesComponent } from './availability-dates.component';

describe('AvailabilityDatesComponent', () => {
  let component: AvailabilityDatesComponent;
  let fixture: ComponentFixture<AvailabilityDatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailabilityDatesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailabilityDatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

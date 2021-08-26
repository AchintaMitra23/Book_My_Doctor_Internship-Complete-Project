import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailabilityDatesRegComponent } from './availability-dates-reg.component';

describe('AvailabilityDatesRegComponent', () => {
  let component: AvailabilityDatesRegComponent;
  let fixture: ComponentFixture<AvailabilityDatesRegComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailabilityDatesRegComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailabilityDatesRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

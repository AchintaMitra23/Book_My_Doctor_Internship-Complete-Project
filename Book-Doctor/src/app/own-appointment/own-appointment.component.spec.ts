import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnAppointmentComponent } from './own-appointment.component';

describe('OwnAppointmentComponent', () => {
  let component: OwnAppointmentComponent;
  let fixture: ComponentFixture<OwnAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnAppointmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

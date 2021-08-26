import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentByPatientComponent } from './appointment-by-patient.component';

describe('AppointmentByPatientComponent', () => {
  let component: AppointmentByPatientComponent;
  let fixture: ComponentFixture<AppointmentByPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentByPatientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentByPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

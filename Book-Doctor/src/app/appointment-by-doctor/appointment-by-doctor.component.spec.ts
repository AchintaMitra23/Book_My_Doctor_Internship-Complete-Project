import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentByDoctorComponent } from './appointment-by-doctor.component';

describe('AppointmentByDoctorComponent', () => {
  let component: AppointmentByDoctorComponent;
  let fixture: ComponentFixture<AppointmentByDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentByDoctorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentByDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

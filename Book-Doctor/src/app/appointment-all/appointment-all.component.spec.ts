import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentAllComponent } from './appointment-all.component';

describe('AppointmentAllComponent', () => {
  let component: AppointmentAllComponent;
  let fixture: ComponentFixture<AppointmentAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentAllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

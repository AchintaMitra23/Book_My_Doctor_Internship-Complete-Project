import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorBySpecialityComponent } from './doctor-by-speciality.component';

describe('DoctorBySpecialityComponent', () => {
  let component: DoctorBySpecialityComponent;
  let fixture: ComponentFixture<DoctorBySpecialityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorBySpecialityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorBySpecialityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

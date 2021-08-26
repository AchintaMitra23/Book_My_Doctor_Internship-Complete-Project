import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGetDoctorByIdComponent } from './admin-get-doctor-by-id.component';

describe('AdminGetDoctorByIdComponent', () => {
  let component: AdminGetDoctorByIdComponent;
  let fixture: ComponentFixture<AdminGetDoctorByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminGetDoctorByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminGetDoctorByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

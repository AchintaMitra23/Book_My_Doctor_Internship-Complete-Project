import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorRegComponent } from './doctor-reg.component';

describe('DoctorRegComponent', () => {
  let component: DoctorRegComponent;
  let fixture: ComponentFixture<DoctorRegComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorRegComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientByBloodgroupComponent } from './patient-by-bloodgroup.component';

describe('PatientByBloodgroupComponent', () => {
  let component: PatientByBloodgroupComponent;
  let fixture: ComponentFixture<PatientByBloodgroupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientByBloodgroupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientByBloodgroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

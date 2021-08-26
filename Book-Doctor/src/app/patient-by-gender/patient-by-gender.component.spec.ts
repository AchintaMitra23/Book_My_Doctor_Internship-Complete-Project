import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientByGenderComponent } from './patient-by-gender.component';

describe('PatientByGenderComponent', () => {
  let component: PatientByGenderComponent;
  let fixture: ComponentFixture<PatientByGenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientByGenderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientByGenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

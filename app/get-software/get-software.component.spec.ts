import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetSoftwareComponent } from './get-software.component';

describe('GetSoftwareComponent', () => {
  let component: GetSoftwareComponent;
  let fixture: ComponentFixture<GetSoftwareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetSoftwareComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetSoftwareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

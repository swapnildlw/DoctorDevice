import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicecenterComponent } from './servicecenterservice.component';

describe('ServicecenterComponent', () => {
  let component: ServicecenterComponent;
  let fixture: ComponentFixture<ServicecenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServicecenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServicecenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

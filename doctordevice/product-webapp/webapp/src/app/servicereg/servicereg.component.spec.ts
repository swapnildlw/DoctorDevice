import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceCenter } from './servicereg.component';

describe('ServiceregComponent', () => {
  let component: ServiceCenter;
  let fixture: ComponentFixture<ServiceCenter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceCenter ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServiceCenter);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

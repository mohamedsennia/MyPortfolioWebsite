import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTechnologieComponent } from './add-technologie.component';

describe('AddTechnologieComponent', () => {
  let component: AddTechnologieComponent;
  let fixture: ComponentFixture<AddTechnologieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddTechnologieComponent]
    });
    fixture = TestBed.createComponent(AddTechnologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

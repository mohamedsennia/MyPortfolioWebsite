import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTechnologieComponent } from './edit-technologie.component';

describe('EditTechnologieComponent', () => {
  let component: EditTechnologieComponent;
  let fixture: ComponentFixture<EditTechnologieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditTechnologieComponent]
    });
    fixture = TestBed.createComponent(EditTechnologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowExperiencesComponent } from './show-experiences.component';

describe('ShowExperiencesComponent', () => {
  let component: ShowExperiencesComponent;
  let fixture: ComponentFixture<ShowExperiencesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowExperiencesComponent]
    });
    fixture = TestBed.createComponent(ShowExperiencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

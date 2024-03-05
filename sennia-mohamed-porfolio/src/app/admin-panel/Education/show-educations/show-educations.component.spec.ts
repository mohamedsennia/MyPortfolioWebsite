import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowEducationsComponent } from './show-educations.component';

describe('ShowEducationsComponent', () => {
  let component: ShowEducationsComponent;
  let fixture: ComponentFixture<ShowEducationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowEducationsComponent]
    });
    fixture = TestBed.createComponent(ShowEducationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSecondComponent } from './create-second.component';

describe('CreateSecondComponent', () => {
  let component: CreateSecondComponent;
  let fixture: ComponentFixture<CreateSecondComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSecondComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSecondComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

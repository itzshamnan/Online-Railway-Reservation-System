import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainNoComponent } from './train-no.component';

describe('TrainNoComponent', () => {
  let component: TrainNoComponent;
  let fixture: ComponentFixture<TrainNoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainNoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainNoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

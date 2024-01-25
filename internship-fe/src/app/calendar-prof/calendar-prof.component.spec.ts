import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarProfComponent } from './calendar-prof.component';

describe('CalendarProfComponent', () => {
  let component: CalendarProfComponent;
  let fixture: ComponentFixture<CalendarProfComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CalendarProfComponent]
    });
    fixture = TestBed.createComponent(CalendarProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

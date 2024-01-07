import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarEtuComponent } from './calendar-etu.component';

describe('CalendarEtuComponent', () => {
  let component: CalendarEtuComponent;
  let fixture: ComponentFixture<CalendarEtuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CalendarEtuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CalendarEtuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

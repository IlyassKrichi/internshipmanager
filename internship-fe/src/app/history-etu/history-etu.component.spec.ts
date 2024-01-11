import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryEtuComponent } from './history-etu.component';

describe('HistoryEtuComponent', () => {
  let component: HistoryEtuComponent;
  let fixture: ComponentFixture<HistoryEtuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HistoryEtuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HistoryEtuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

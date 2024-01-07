import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusEtuComponent } from './status-etu.component';

describe('StatusEtuComponent', () => {
  let component: StatusEtuComponent;
  let fixture: ComponentFixture<StatusEtuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatusEtuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StatusEtuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusProfComponent } from './status-prof.component';

describe('StatusProfComponent', () => {
  let component: StatusProfComponent;
  let fixture: ComponentFixture<StatusProfComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StatusProfComponent]
    });
    fixture = TestBed.createComponent(StatusProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

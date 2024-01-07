import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatEtuComponent } from './chat-etu.component';

describe('ChatEtuComponent', () => {
  let component: ChatEtuComponent;
  let fixture: ComponentFixture<ChatEtuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChatEtuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChatEtuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileEtuComponent } from './profile-etu.component';

describe('ProfileEtuComponent', () => {
  let component: ProfileEtuComponent;
  let fixture: ComponentFixture<ProfileEtuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfileEtuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfileEtuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

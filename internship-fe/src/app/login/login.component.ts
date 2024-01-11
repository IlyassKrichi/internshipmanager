import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  studentsHover: boolean = false;
  professorsHover: boolean = false;
  studentsClick: boolean = false;
  professorsClick: boolean = false;
  flag: boolean = true;

  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit(): void {
    this.authService
      .login(
        this.loginForm.value.username ?? '',
        this.loginForm.value.password ?? ''
      )
      .subscribe({
        next: (response) => {
          localStorage.setItem('token', response.token);
          this.router.navigate(['/dashboard']);
        },
        error: (error) => {
          console.error('Something went wrong!', error);
        },
      });
  }

  toggleHover(group: 'students' | 'professors'): void {
    if (this.flag) {
      if (group === 'students') {
        this.studentsHover = !this.studentsHover;
      } else if (group === 'professors') {
        this.professorsHover = !this.professorsHover;
      }
    }
  }

  toggleClick(group: 'students' | 'professors'): void {
    if (group === 'students') {
      this.studentsClick = !this.studentsClick;
      history.pushState(null, '', '/login/étudiants');
    } else if (group === 'professors') {
      this.professorsClick = !this.professorsClick;
      history.pushState(null, '', '/login/professeurs');
    }
    this.flag = !this.flag;
  }

  toggleBack(group: 'students' | 'professors'): void {
    if (group === 'students') {
      this.studentsClick = !this.studentsClick;
      this.studentsHover = false;
    } else if (group === 'professors') {
      this.professorsClick = !this.professorsClick;
      this.professorsHover = false;
    }
    this.flag = !this.flag;
    history.back();
  }
}

import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  studentsHover: boolean = false;
  professorsHover: boolean = false;

  toggleHover(group: 'students' | 'professors'): void {
    if (group === 'students') {
      this.studentsHover = !this.studentsHover;
      console.log('Students Hover:', this.studentsHover);
    } else if (group === 'professors') {
      this.professorsHover = !this.professorsHover;
      console.log('Professors Hover:', this.professorsHover);
    }
  }
}

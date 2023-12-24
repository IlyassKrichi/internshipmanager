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
  studentsClick: boolean = false;
  professorsClick: boolean = false;
  flag: boolean = true;

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

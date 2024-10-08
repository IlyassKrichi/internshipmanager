import {Component} from '@angular/core';






@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  imports: [],
  standalone: true,
  styleUrls: ['./login.component.scss'], // Corrected from styleUrl to styleUrls
})
export class LoginComponent {
  // Your component logic here
  studentsHover: boolean = false;
  professorsHover: boolean = false;
  studentsClick: boolean = false;
  professorsClick: boolean = false;
  flag: boolean = true;

  constructor() {

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

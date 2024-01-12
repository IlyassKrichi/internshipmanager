import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-etu',
  templateUrl: './profile-prof.component.html',
  styleUrls: ['./profile-prof.component.scss'],
})
export class ProfileProfComponent {
  fieldInactive = false;
  btnActive = false;
  textActive = false;

  constructor(private router: Router) {}

  navigateToDashboard(): void {
    this.router.navigate(['professeur/dashboard']);
  }

  navigateToProfile(): void {
    this.router.navigate(['professeur/profil']);
  }

  navigateToCalendar(): void {
    this.router.navigate(['professeur/calendrier']);
  }

  navigateToStatus(): void {
    this.router.navigate(['professeur/statut']);
  }

  toggleInactive(): void {
    this.fieldInactive = true;
    this.btnActive = true;
    this.textActive = true;
    var modify = document.getElementById('modify');
    if (modify !== null) {
      modify.innerHTML = 'Enregistrer';
    }
  }

  toggleActive(): void {
    this.fieldInactive = false;
    this.btnActive = false;
    this.textActive = false;
    var modify = document.getElementById('modify');
    if (modify !== null) {
      modify.innerHTML = 'Modifier';
    }
  }
}

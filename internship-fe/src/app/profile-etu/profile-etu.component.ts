import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-etu',
  templateUrl: './profile-etu.component.html',
  styleUrls: ['./profile-etu.component.scss'],
})
export class ProfileEtuComponent {
  fieldInactive = false;
  btnActive = false;
  textActive = false;

  constructor(private router: Router) {}

  navigateToDashboard(): void {
    this.router.navigate(['étudiant/dashboard']);
  }

  navigateToProfile(): void {
    this.router.navigate(['étudiant/profil']);
  }

  navigateToHistory(): void {
    this.router.navigate(['étudiant/historique']);
  }

  navigateToCalendar(): void {
    this.router.navigate(['étudiant/calendrier']);
  }

  navigateToStatus(): void {
    this.router.navigate(['étudiant/statut']);
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

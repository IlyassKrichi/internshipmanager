import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-etu',
  standalone: true,
  imports: [],
  templateUrl: './profile-etu.component.html',
  styleUrl: './profile-etu.component.scss',
})
export class ProfileEtuComponent {
  fieldInactive = false;
  btnActive = false;
  textActive = false;

  constructor(private router: Router) {}

  navigateToDashboard(): void {
    this.router.navigate(['/dashboard']);
  }

  navigateToProfile(): void {
    this.router.navigate(['/profil']);
  }

  navigateToHistory(): void {
    this.router.navigate(['/historique']);
  }

  navigateToCalendar(): void {
    this.router.navigate(['/calendrier']);
  }

  navigateToStatus(): void {
    this.router.navigate(['/statut']);
  }

  navigateToChat(): void {
    this.router.navigate(['/chat']);
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

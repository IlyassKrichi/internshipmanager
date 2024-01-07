import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-status-etu',
  standalone: true,
  imports: [],
  templateUrl: './status-etu.component.html',
  styleUrl: './status-etu.component.scss',
})
export class StatusEtuComponent {
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
}

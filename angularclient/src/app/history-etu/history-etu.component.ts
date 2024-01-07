import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-history-etu',
  standalone: true,
  imports: [],
  templateUrl: './history-etu.component.html',
  styleUrl: './history-etu.component.scss',
})
export class HistoryEtuComponent {
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

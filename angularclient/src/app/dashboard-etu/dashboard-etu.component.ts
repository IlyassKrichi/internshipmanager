import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-etu',
  standalone: true,
  imports: [],
  templateUrl: './dashboard-etu.component.html',
  styleUrl: './dashboard-etu.component.scss',
})
export class DashboardEtuComponent {
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

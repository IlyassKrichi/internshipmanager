import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-calendar-etu',
  standalone: true,
  imports: [],
  templateUrl: './calendar-etu.component.html',
  styleUrl: './calendar-etu.component.scss',
})
export class CalendarEtuComponent {
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

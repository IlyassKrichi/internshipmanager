import { HttpClient } from '@angular/common/http';
import { Component, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
@Component({
  selector: 'app-dashboard-etu',
  templateUrl: './dashboard-etu.component.html',
  styleUrls: ['./dashboard-etu.component.scss'],
})
export class DashboardEtuComponent {
  private apiUrl = 'http://localhost:8080/etudiants';
  constructor(private router: Router, private http: HttpClient) {}

  getUsers(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

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
}

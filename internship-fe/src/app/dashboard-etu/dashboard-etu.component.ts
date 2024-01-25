import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';
import { AuthService } from '../auth-service.service';
import { Etudiant } from '../objects/Etudiant';

@Component({
  selector: 'app-dashboard-etu',
  templateUrl: './dashboard-etu.component.html',
  styleUrls: ['./dashboard-etu.component.scss'],
})
export class DashboardEtuComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService) {}

  etudiant: Etudiant | undefined;

  ngOnInit(): void {
    const token = this.authService.getTokens();

    if (token) {
      const decodeToken: any = jwtDecode(token);

      const email = decodeToken.sub;

      this.authService.getEtudiantByEmail(email).subscribe({
        next: (etudiant) => {
          this.etudiant = etudiant;
        },
        error: (error) => {
          console.log(error);
        },
      });
    }
  }

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
}

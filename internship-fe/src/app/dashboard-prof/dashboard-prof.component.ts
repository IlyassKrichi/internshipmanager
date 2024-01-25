import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';
import { AuthService } from '../auth-service.service';
import { Professeur } from '../objects/Professeur';

@Component({
  selector: 'app-dashboard-etu',
  templateUrl: './dashboard-prof.component.html',
  styleUrls: ['./dashboard-prof.component.scss'],
})
export class DashboardProfComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService) {}

  professeur: Professeur | undefined;

  ngOnInit(): void {
    const token = this.authService.getTokens();

    if (token) {
      const decodeToken: any = jwtDecode(token);

      const email = decodeToken.sub;

      this.authService.getProfesseurByEmail(email).subscribe({
        next: (professeur) => {
          this.professeur = professeur;
        },
        error: (error) => {
          console.log(error);
        },
      });
    }
  }

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
}

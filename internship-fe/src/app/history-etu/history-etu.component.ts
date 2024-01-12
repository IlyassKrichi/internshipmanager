import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';
import { AuthService } from '../auth-service.service';
import { Etudiant } from '../objects/Etudiant';

@Component({
  selector: 'app-history-etu',
  templateUrl: './history-etu.component.html',
  styleUrls: ['./history-etu.component.scss'],
})
export class HistoryEtuComponent implements OnInit {
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
          console.log(this.etudiant);
        },
        error: (error) => {
          console.log(error);
        },
      });
    }
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

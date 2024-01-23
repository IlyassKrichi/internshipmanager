import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';
import { AuthService } from '../auth-service.service';
import { Etudiant } from '../objects/Etudiant';
import { Stage } from '../objects/Stage';

@Component({
  selector: 'app-history-etu',
  templateUrl: './history-etu.component.html',
  styleUrls: ['./history-etu.component.scss'],
})
export class HistoryEtuComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService) {}

  etudiant: Etudiant | undefined;
  stages: Stage[] | undefined;

  ngOnInit(): void {
    const token = this.authService.getTokens();

    if (token) {
      const decodeToken: any = jwtDecode(token);

      const email = decodeToken.sub;

      this.authService.getStagesByEmail(email).subscribe({
        next: (stages) => {
          this.stages = stages;
          console.log(this.stages);
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

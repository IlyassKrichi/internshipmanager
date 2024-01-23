import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';
import { AuthService } from '../auth-service.service';
import { Professeur } from '../objects/Professeur';

@Component({
  selector: 'app-profile-etu',
  templateUrl: './profile-prof.component.html',
  styleUrls: ['./profile-prof.component.scss'],
})
export class ProfileProfComponent implements OnInit {
  fieldInactive = false;
  btnActive = false;
  textActive = false;

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

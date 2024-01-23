import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';
import { AuthService } from '../auth-service.service';
import { Etudiant } from '../objects/Etudiant';

@Component({
  selector: 'app-profile-etu',
  templateUrl: './profile-etu.component.html',
  styleUrls: ['./profile-etu.component.scss'],
})
export class ProfileEtuComponent implements OnInit {
  fieldInactive = false;
  btnActive = false;
  textActive = false;

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

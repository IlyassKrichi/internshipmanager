import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-status-etu',
  templateUrl: './status-etu.component.html',
  styleUrls: ['./status-etu.component.scss'],
})
export class StatusEtuComponent {
  uploadActive: boolean = false;
  fileName: string = '';

  constructor(private router: Router) {}

  uploadActivated(): void {
    let fileInput = document.getElementById('fileInput') as HTMLInputElement;
    if (this.uploadActive) {
      fileInput.value = '';
      this.fileName = '';
      this.uploadActive = false;
    } else {
      fileInput.click();

      fileInput.addEventListener('change', (event) => {
        if (fileInput.files && fileInput.files.length > 0) {
          this.uploadActive = true;
          this.fileName = 'Fichier : ' + fileInput.files[0].name;
        }
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

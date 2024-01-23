import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PdfServiceService } from '../pdf-service.service';

@Component({
  selector: 'app-status-etu',
  templateUrl: './status-etu.component.html',
  styleUrls: ['./status-etu.component.scss'],
})
export class StatusEtuComponent {
  uploadActive: boolean = false;
  fileName: string = '';

  constructor(private router: Router, private pdfService: PdfServiceService) {}

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

  upload(event: Event): void {
    const file: File | null =
      (event.target as HTMLInputElement).files?.[0] || null;
    if (file) {
      console.log(file);
      this.pdfService.uploadFile(file)?.subscribe((response) => {
        console.log(response);
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

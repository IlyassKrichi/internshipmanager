import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etudiant } from './objects/Etudiant';
import { Professeur } from './objects/Professeur';
import { Stage } from './objects/Stage';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<any> {
    const credentials = { email: email, password: password };
    return this.http.post<any>(this.apiUrl + '/auth/authenticate', credentials);
  }

  getTokens(): string | null {
    return localStorage.getItem('token');
  }

  getEtudiantByEmail(email: string): Observable<Etudiant> {
    const token = this.getTokens();
    if (token) {
      const headers = {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      };

      return this.http.get<Etudiant>(this.apiUrl + '/etudiant/' + email, {
        headers: headers,
      });
    } else {
      throw new Error('No token');
    }
  }

  getProfesseurByEmail(email: string): Observable<Professeur> {
    const token = this.getTokens();
    if (token) {
      const headers = {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      };

      return this.http.get<Professeur>(this.apiUrl + '/professeur/' + email, {
        headers: headers,
      });
    } else {
      throw new Error('No token');
    }
  }

  getStagesByEmail(email: string): Observable<Stage[]> {
    const token = this.getTokens();
    if (token) {
      const headers = {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      };

      return this.http.get<Stage[]>(this.apiUrl + '/stages/' + email, {
        headers: headers,
      });
    } else {
      throw new Error('No token');
    }
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etudiant } from './objects/Etudiant';
import { Stage } from './objects/Stage';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

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

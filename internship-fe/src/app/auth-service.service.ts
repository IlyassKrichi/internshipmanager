import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/v1/auth/';

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<any> {
    const credentials = { email: email, password: password };
    return this.http.post<any>(this.apiUrl + 'authenticate', credentials);
  }

  getTokens(): String | null {
    return localStorage.getItem('token');
  }
}

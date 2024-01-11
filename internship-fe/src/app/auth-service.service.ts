import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, tap, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080/api/auth/login'; // Fix the typo in the URL

  constructor(private http: HttpClient) { }


  authenticate(email: string, password: any): Observable<any> {
    const credentials = { email: email, password: password };
    return this.http.post(this.baseUrl, credentials)
      .pipe(
        catchError(this.handleError),
        tap(response => console.log('Authentication response:', response))
      );
  }


  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    return throwError('Something went wrong, please try again later.'); // You can customize the error message
  }
}

import { Component } from '@angular/core';
import {FormGroup, FormBuilder, Validators, ReactiveFormsModule} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth-service.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss'],
  imports: [
    ReactiveFormsModule
  ],
  standalone: true
})
export class LoginFormComponent {

  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]  // Added password field
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      this.authService.authenticate(email, password).subscribe({
        next: (response: any) => {
          console.log('Form is submitted.');
          // Handle the response from the backend
          if (response.success) {
            // Redirect to another component or route
            this.router.navigate(['/dashboard']).then(r => true); // Replace with your desired route
          } else {
            // Handle authentication failure
            console.error('Authentication failed:', response.message);
          }
        },
        error: (error: any) => {
          // Handle error from the backend
          console.error('Something went wrong!', error);
        }
      });
    }
  }
}

import { Routes } from '@angular/router';
import path from 'node:path';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login/étudiants',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login/professeurs',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
  },
];

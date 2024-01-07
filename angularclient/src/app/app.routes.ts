import { Routes } from '@angular/router';
import path from 'node:path';
import { AppComponent } from './app.component';
import { CalendarEtuComponent } from './calendar-etu/calendar-etu.component';
import { ChatEtuComponent } from './chat-etu/chat-etu.component';
import { DashboardEtuComponent } from './dashboard-etu/dashboard-etu.component';
import { HistoryEtuComponent } from './history-etu/history-etu.component';
import { LoginComponent } from './login/login.component';
import { ProfileEtuComponent } from './profile-etu/profile-etu.component';
import { StatusEtuComponent } from './status-etu/status-etu.component';

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
  {
    path: 'dashboard',
    component: DashboardEtuComponent,
  },
  {
    path: 'profil',
    component: ProfileEtuComponent,
  },
  {
    path: 'historique',
    component: HistoryEtuComponent,
  },
  {
    path: 'calendrier',
    component: CalendarEtuComponent,
  },
  {
    path: 'statut',
    component: StatusEtuComponent,
  },
  {
    path: 'chat',
    component: ChatEtuComponent,
  },
  {
    path: '**',
    component: DashboardEtuComponent,
  },
];

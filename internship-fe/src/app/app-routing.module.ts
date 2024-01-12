import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalendarEtuComponent } from './calendar-etu/calendar-etu.component';
import { CalendarProfComponent } from './calendar-prof/calendar-prof.component';
import { DashboardEtuComponent } from './dashboard-etu/dashboard-etu.component';
import { DashboardProfComponent } from './dashboard-prof/dashboard-prof.component';
import { HistoryEtuComponent } from './history-etu/history-etu.component';
import { LoginComponent } from './login/login.component';
import { ProfileEtuComponent } from './profile-etu/profile-etu.component';
import { ProfileProfComponent } from './profile-prof/profile-prof.component';
import { StatusEtuComponent } from './status-etu/status-etu.component';
import { StatusProfComponent } from './status-prof/status-prof.component';

const routes: Routes = [
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
    path: 'étudiant/dashboard',
    component: DashboardEtuComponent,
  },

  {
    path: 'étudiant/profil',
    component: ProfileEtuComponent,
  },
  {
    path: 'étudiant/historique',
    component: HistoryEtuComponent,
  },
  {
    path: 'étudiant/calendrier',
    component: CalendarEtuComponent,
  },
  {
    path: 'étudiant/statut',
    component: StatusEtuComponent,
  },
  {
    path: 'professeur/dashboard',
    component: DashboardProfComponent,
  },

  {
    path: 'professeur/profil',
    component: ProfileProfComponent,
  },
  {
    path: 'professeur/calendrier',
    component: CalendarProfComponent,
  },
  {
    path: 'professeur/statut',
    component: StatusProfComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

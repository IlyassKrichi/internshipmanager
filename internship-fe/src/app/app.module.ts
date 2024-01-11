import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { FlatpickrModule } from 'angularx-flatpickr';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalendarEtuComponent } from './calendar-etu/calendar-etu.component';
import { DashboardEtuComponent } from './dashboard-etu/dashboard-etu.component';
import { HistoryEtuComponent } from './history-etu/history-etu.component';
import { LoginComponent } from './login/login.component';
import { ProfileEtuComponent } from './profile-etu/profile-etu.component';
import { StatusEtuComponent } from './status-etu/status-etu.component';

@NgModule({
  declarations: [
    AppComponent,
    CalendarEtuComponent,
    DashboardEtuComponent,
    HistoryEtuComponent,
    LoginComponent,
    ProfileEtuComponent,
    StatusEtuComponent,
  ],
  imports: [
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
  ],
  providers: [],
  exports: [CalendarEtuComponent],
  bootstrap: [AppComponent],
})
export class AppModule {}

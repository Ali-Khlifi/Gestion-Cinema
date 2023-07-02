import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CinemaComponent } from './components/cinema/cinema.component';
import {HttpClientModule} from "@angular/common/http";
import {CinemaService} from "./services/cinema/cinema.service";
import {FormsModule} from "@angular/forms";
import { VillesComponent } from './components/villes/villes.component';
import { HomeComponent } from './components/home/home.component';
import { SallesComponent } from './components/salles/salles.component';
import { SeancesComponent } from './components/seances/seances.component';
import { FilmProjectionsComponent } from './components/film-projections/film-projections.component';
import { FilmsComponent } from './components/films/films.component';
import { EvenementsComponent } from './components/evenements/evenements.component';
import { OffresComponent } from './components/offres/offres.component';

@NgModule({
  declarations: [
    AppComponent,
    CinemaComponent,
    VillesComponent,
    HomeComponent,
    SallesComponent,
    SeancesComponent,
    FilmProjectionsComponent,
    FilmsComponent,
    EvenementsComponent,
    OffresComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CinemaService],
  bootstrap: [AppComponent]
})
export class AppModule { }

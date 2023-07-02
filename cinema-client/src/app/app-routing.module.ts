import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ComponentFixture} from "@angular/core/testing";
import {CinemaComponent} from "./components/cinema/cinema.component";
import {FilmsComponent} from "./components/films/films.component";
import {EvenementsComponent} from "./components/evenements/evenements.component";
import {OffresComponent} from "./components/offres/offres.component";

const routes: Routes = [
  {
    path : "cinemas", component: CinemaComponent,
  },
  {
    path : "films", component: FilmsComponent
  },
  {
    path : "evenements", component: EvenementsComponent
  },
  {
    path : "offres", component: OffresComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ComponentFixture} from "@angular/core/testing";
import {CinemaComponent} from "./components/cinema/cinema.component";

const routes: Routes = [
  {
    path : "cinema", component: CinemaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

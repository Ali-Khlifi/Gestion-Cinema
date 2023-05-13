import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../services/cinema.service";

@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrls: ['./cinema.component.css']
})
export class CinemaComponent implements OnInit{
  public villes:any;
  public cinemas:any;
  public currentVille :any;
  public currentCinema :any;
  public salles:any;
  public filmProjections: any;
  public seances :any;
  constructor( public serviceCinema: CinemaService) {
  }
  ngOnInit() {
    this.serviceCinema.getVilles()
      .subscribe(data=>{
        this.villes = data;
      }, error => {
        console.log(error);
      })
  }
  OnGetCinema(v: any) {
    this.currentVille = v;
    this.serviceCinema.getCinema(v)
      .subscribe(data=>{
        this.cinemas = data;
      }, error => {
        console.log(error);
      })
  }

  OnGetSalles(c:any) {
    this.currentCinema = c;
    this.serviceCinema.getSalles(c)
      .subscribe(data=>{
        this.salles = data
        // recuperation des projections une fois la salle est récupérée
        this.salles._embedded.salles.forEach((salle: any) =>{
          this.serviceCinema.getProjections(salle)
            .subscribe((data: any)=>{
              salle.filmProjections = data;
            }, (error: any) => {
              console.log(error);
            })
        })
      }, error => {
        console.log(error);
      })
  }
}

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
  constructor( private serviceCinema: CinemaService) {
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
    this.serviceCinema.getCinema(v)
      .subscribe(data=>{
        this.cinemas = data;
      }, error => {
        console.log(error);
      })
  }
}

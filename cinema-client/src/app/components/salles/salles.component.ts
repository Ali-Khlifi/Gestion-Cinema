import {Component, Input, OnInit, SimpleChanges} from '@angular/core';
import {Salle} from "../../models/salle.model";
import {SalleService} from "../../services/salle/salle.service";
import {Cinema} from "../../models/cinema.model";

@Component({
  selector: 'app-salles',
  templateUrl: './salles.component.html',
  styleUrls: ['./salles.component.css']
})
export class SallesComponent implements OnInit {

  @Input() cinema!: Cinema;
  salles : Salle[] = [];

  constructor(private serviceSalle: SalleService){}

  ngOnInit(): void {
  }


  ngOnChanges(changes: SimpleChanges) {
    if (changes['cinema']) {
      this.OnGetSalles(this.cinema);
    }
  }

  OnGetSalles(c:Cinema) {
    this.serviceSalle.getSalles(c.name)
      .subscribe(salles =>{
        this.salles = salles
      })
  }



}

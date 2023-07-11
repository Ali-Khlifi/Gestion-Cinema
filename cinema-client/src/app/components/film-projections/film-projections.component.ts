import {Component, OnInit} from '@angular/core';
import {FilmProjectionService} from "../../services/film-projection/film-projection.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-film-projections',
  templateUrl: './film-projections.component.html',
  styleUrls: ['./film-projections.component.css']
})
export class FilmProjectionsComponent implements OnInit{

  filmId: number = 1;
  imageFilm!:any

  constructor(private filmProjectionService: FilmProjectionService) {
  }
  ngOnInit(): void {
    this.filmProjectionService.getImageByFilm(this.filmId).subscribe(data => {
      let read = new FileReader();
      read.readAsDataURL(data);
      read.onloadend = () => {
        this.imageFilm = read.result;
      }
    }, error => {
      console.log(error);
    });
  }
}

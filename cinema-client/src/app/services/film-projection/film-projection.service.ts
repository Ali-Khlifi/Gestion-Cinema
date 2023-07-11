import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class FilmProjectionService {

  constructor(private http: HttpClient) { }

  urlApi = environment.API_URL;
  urlImageFilm = this.urlApi + "/imageFilm"


  public getImageByFilm(filmId: number){
    return this.http.get(this.urlImageFilm + "/" + filmId, {responseType: 'blob'})
  }

  public getFilmProjectionBySalle(salleId: number){

  }


}

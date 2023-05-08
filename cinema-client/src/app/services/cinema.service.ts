import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CinemaService {
  constructor(private http : HttpClient) { }

  public host : String = "http://localhost:8080"
  public getVilles() {
    return this.http.get(this.host + "/villes");
  }
  public getCinema(v:any){
    return this.http.get(v._links.cinemas.href);
  }

  getSalles(c:any) {
    return this.http.get(c._links.salles.href);


  }

  getProjections(salle: any) {
      let url = salle._links.filmProjections.href.replace("{?projection}", "");
      return this.http.get(url + "?projection=p1");
  }

}

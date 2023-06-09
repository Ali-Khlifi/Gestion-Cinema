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
    let url = c._links.salles.href.replace("{?projection}", "");
    return this.http.get(url + "?projection=salleProj");
  }

  getProjections(salle: any) {
      let url = salle._links.filmProjections.href.replace("{?projection}", "");
      return this.http.get(url + "?projection=p1");
  }

  getTicketsPlaces(p: any) {
    let url = p._links.tickets.href.replace("{?projection}", "");
    return this.http.get(url + "?projection=ticketProj");
  }

  payerTickets(dataForm: any) {
    return this.http.post(this.host + "/ticketsVendus", dataForm)
  }
}

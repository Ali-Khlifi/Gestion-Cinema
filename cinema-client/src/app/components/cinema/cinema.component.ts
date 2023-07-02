import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../services/cinema/cinema.service";

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
  public currentProject :any;
  tickets: any;
  currentSeance: any;
  public selectedTickets: any[] = [];
  constructor( public serviceCinema: CinemaService) {
  }
  ngOnInit() {
    this.serviceCinema.getVilles()
      .subscribe(data=>{
        this.villes = data;
      })
  }
  OnGetCinema(v: any) {
    this.currentVille = v;
    this.salles = undefined;  // vider la liste des salles
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

  OnGetTicketsPlaces(p:any) {
    this.currentProject = p;
    this.serviceCinema.getTicketsPlaces(p)
      .subscribe(data => {
        this.currentProject.tickets = data;
        this.selectedTickets = [];
      })
  }

  OnSelectTicket(t: any) {
    // initialize the selected ticket in true on click
    if(!t.selected) {
      // added a new selected ticket to the list
      t.selected = true;
      this.selectedTickets.push(t);
    } else {
      // removed a selected ticket from the list
      t.selected = false;
      this.selectedTickets.splice(this.selectedTickets.indexOf(t), 1);
    }
    console.log(this.selectedTickets);

  }
  getTicketPlace(t: any) {
    let str ="btn ticket ";
    if(t.reservee == true){
      str +=" btn-danger'"
    }  else if (t.selected) {
      str += "btn-warning";
    } else {
      str += "btn-success"
    }
    return str;

  }
  onPayTickets(dataForm:any) {

    let tickets: any[] = [];
    this.selectedTickets.forEach(t => {tickets.push(t.id);
    });
    dataForm.tickets = tickets;
    this.serviceCinema.payerTickets(dataForm)
      .subscribe(data => {alert("Ticket Réservé ! Merci pour votre confiance")})

    // recharger les tickets de la projection courante après reservation
    this.OnGetTicketsPlaces(this.currentProject);
  }
}

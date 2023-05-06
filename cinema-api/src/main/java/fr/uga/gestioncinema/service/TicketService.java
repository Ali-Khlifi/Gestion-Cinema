package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.dao.FilmProjectionRepository;
import fr.uga.gestioncinema.dao.PlaceRepository;
import fr.uga.gestioncinema.dao.TicketRepository;
import fr.uga.gestioncinema.entities.FilmProjection;
import fr.uga.gestioncinema.entities.Place;
import fr.uga.gestioncinema.entities.Ticket;
import fr.uga.gestioncinema.web.formes.TicketForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    FilmProjectionRepository filmProjectionRepository;
    @Override
    public List<Ticket> payerTickets(TicketForm ticketForm) {
        // Creation d'une liste vide pour les tickets vendus pour les réserves
        List<Ticket> ticketsVendus = new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket ->{
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReservee(true);
            ticketRepository.save(ticket);
            ticketsVendus.add(ticket);
        });
        return ticketsVendus;
    }
    @Override
    public Ticket addTicket(TicketForm ticketForm) {
        Ticket ticket = new Ticket();
        ticket.setNomClient(ticketForm.getNomClient());
        ticket.setCodePayement(ticketForm.getCodePayement());
        ticket.setPrix(ticketForm.getPrix());
        ticket.setReservee(true);

        // Récupérer la place et la projection d'un film à partir de leurs ID et mise à jour de l'objet Ticket
        Optional<Place> place = placeRepository.findById(ticketForm.getPlaceId());
        Optional<FilmProjection> projection = filmProjectionRepository.findById(ticketForm.getFilmProjectionId());

        if(place.isPresent() && projection.isPresent()){
            ticket.setPlace(place.get());
            ticket.setFilmProjection(projection.get());
        }
        return ticketRepository.save(ticket);
    }
}

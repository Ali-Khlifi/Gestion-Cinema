package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.entities.Ticket;
import fr.uga.gestioncinema.web.formes.TicketForm;

import java.util.List;

public interface ITicketService {
    List<Ticket> payerTickets(TicketForm ticketForm);
    Ticket addTicket(TicketForm ticketForm);
}

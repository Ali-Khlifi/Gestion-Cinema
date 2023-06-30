package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.dto.CinemaDto;
import fr.uga.gestioncinema.dto.TicketDto;
import fr.uga.gestioncinema.entities.Ticket;
import fr.uga.gestioncinema.web.formes.TicketForm;
import jakarta.validation.Valid;

import java.util.List;

public interface TicketService {
    List<Ticket> payerTickets(TicketForm ticketForm);
    Ticket addTicket(TicketForm ticketForm);
    TicketDto fetchOne(Long id);
    TicketDto save(@Valid TicketDto dto);
    List<TicketDto> fetchAll();
    TicketDto update(@Valid TicketDto dto);

    void delete(Long id);
}

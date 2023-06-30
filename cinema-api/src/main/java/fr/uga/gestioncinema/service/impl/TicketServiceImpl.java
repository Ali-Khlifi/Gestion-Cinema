package fr.uga.gestioncinema.service.impl;

import fr.uga.gestioncinema.dto.CinemaDto;
import fr.uga.gestioncinema.dto.TicketDto;
import fr.uga.gestioncinema.entities.Ticket;
import fr.uga.gestioncinema.exceptions.NotFoundException;
import fr.uga.gestioncinema.mappers.CinemaMapper;
import fr.uga.gestioncinema.mappers.TicketMapper;
import fr.uga.gestioncinema.repositories.CinemaRepository;
import fr.uga.gestioncinema.repositories.TicketRepository;
import fr.uga.gestioncinema.service.CinemaService;
import fr.uga.gestioncinema.service.TicketService;
import fr.uga.gestioncinema.web.formes.TicketForm;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static fr.uga.gestioncinema.utils.StringUtils.Exceptions.NO_DATA;

@Primary
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;
    private final TicketMapper mapper;

    @Override
    public List<Ticket> payerTickets(TicketForm ticketForm) {
        return null;
    }

    @Override
    public Ticket addTicket(TicketForm ticketForm) {
        return null;
    }

    @Override
    public TicketDto fetchOne(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException(NO_DATA)));
    }

    @Override
    public TicketDto save(TicketDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<TicketDto> fetchAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public TicketDto update(TicketDto dto) {
        final var ticket = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException(NO_DATA));

        mapper.update(dto, ticket);

        return mapper.toDto(repository.save(ticket));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
   /* @Override
    public List<Ticket> payerTickets(TicketForm ticketForm) {
        // Creation d'une liste vide pour les tickets vendus pour les réserves
        List<Ticket> ticketsVendus = new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket -> {
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
        ticket.setReservee(true);

        // Récupérer la place et la projection d'un film à partir de leurs ID et mise à jour de l'objet Ticket
        //Optional<FilmProjection> projection = filmProjectionRepository.findById(ticketForm.getFilmProjectionId());

        //if(place.isPresent() && projection.isPresent()){
        //ticket.setPlace(place.get());
        //ticket.setFilmProjection(projection.get());

        //return ticketRepository.save(ticket);
        //}
        return ticket;*/

}


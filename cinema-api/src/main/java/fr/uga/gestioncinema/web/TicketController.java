package fr.uga.gestioncinema.web;

import fr.uga.gestioncinema.dao.TicketRepository;
import fr.uga.gestioncinema.entities.Ticket;
import fr.uga.gestioncinema.service.TicketService;
import fr.uga.gestioncinema.web.formes.TicketForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TicketController {

    @Autowired
    public TicketService ticketService;
    @Autowired
    public TicketRepository ticketRepository;

    @GetMapping(path = "/tickets")
    public List<Ticket> tickets(){
        return ticketRepository.findAll();
    }
    // liste des tickets qui sont vendus
    // @RequestBody --> les données du ticket sont envoyés dans le corps de la requête sous format JSON
    @PostMapping("/ticketsVendus")
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
        return ticketService.payerTickets(ticketForm);
    }
    @PostMapping("/addTicket")
    public Ticket addTicket(@RequestBody TicketForm ticketForm){
        return ticketService.addTicket(ticketForm);
    }


}

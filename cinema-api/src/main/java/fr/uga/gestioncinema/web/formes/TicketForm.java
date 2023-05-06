package fr.uga.gestioncinema.web.formes;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketForm {
    private String nomClient;
    private int codePayement;
    private double prix;
    private Long PlaceId;
    private boolean reservee;
    private Long FilmProjectionId;
    private List<Long> tickets = new ArrayList<>();

}

package fr.uga.gestioncinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FilmDto {
    private Long id;
    private String titre;
    private Double duree;
    private String realisateur;
    private String description;
    private String photo;
    private LocalDateTime dateSortie;
    private CategorieDto categorie;

}

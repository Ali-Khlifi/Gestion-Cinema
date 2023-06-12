package fr.uga.gestioncinema.dto;

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
    private CategoryDto category;

}

package fr.uga.gestioncinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private double duree;
    private String realisateur;
    private String description;
    private String photo;
    private Date dateSortie;
    @OneToMany(mappedBy = "film")

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // pour bloquer l'affichage des projection (en lecture)// lors de la consultation des films
    private Collection<FilmProjection> filmProjections;
    @ManyToOne // id_categorie est une clé étrangère dans films
    private Categorie categorie;


}

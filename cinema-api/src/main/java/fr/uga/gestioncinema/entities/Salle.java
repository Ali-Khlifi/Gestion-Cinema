package fr.uga.gestioncinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.uga.gestioncinema.entities.Cinema;
import fr.uga.gestioncinema.entities.FilmProjection;
import fr.uga.gestioncinema.entities.Place;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombrePlaces;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cinema cinema;
    @OneToMany(mappedBy = "salle", cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;
    @OneToMany(mappedBy = "salle")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<FilmProjection> filmProjections;
}

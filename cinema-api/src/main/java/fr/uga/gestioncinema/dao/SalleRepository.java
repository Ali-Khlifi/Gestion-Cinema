package fr.uga.gestioncinema.dao;

import fr.uga.gestioncinema.entities.Cinema;
import fr.uga.gestioncinema.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle, Long> {

}

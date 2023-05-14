package fr.uga.gestioncinema.dao;

import fr.uga.gestioncinema.entities.Categorie;
import fr.uga.gestioncinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
// Spring data Rest
// toutes les méthodes hérités de JpaRepository sont accessibles via une API REST
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}

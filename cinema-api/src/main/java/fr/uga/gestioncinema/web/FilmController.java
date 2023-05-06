package fr.uga.gestioncinema.web;

import fr.uga.gestioncinema.dao.FilmRepository;
import fr.uga.gestioncinema.entities.Film;
import fr.uga.gestioncinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmService filmService;

    // listes des films
    @GetMapping(path = "/listFilms")
    private List<Film> films(){
        return filmRepository.findAll();
    }

    @GetMapping(path = "/imagesFilms/{id}")
    public byte []readImages(@PathVariable(name = "id")Long id) throws IOException {
        return filmService.readImages(id);
    }
}

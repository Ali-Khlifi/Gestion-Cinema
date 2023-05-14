package fr.uga.gestioncinema.web;

import fr.uga.gestioncinema.dao.FilmRepository;
import fr.uga.gestioncinema.entities.Film;
import fr.uga.gestioncinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
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

    @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> readImages(@PathVariable(name = "id")Long id) throws IOException {
        byte[] image = filmService.readImages(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}

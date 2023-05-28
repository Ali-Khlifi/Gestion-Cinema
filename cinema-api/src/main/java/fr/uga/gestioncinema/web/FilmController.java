package fr.uga.gestioncinema.web;

import fr.uga.gestioncinema.dao.FilmRepository;
import fr.uga.gestioncinema.entities.Film;
import fr.uga.gestioncinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin("*")
public class FilmController {
    private FilmRepository filmRepository;
    private FilmService filmService;

    public FilmController(FilmRepository filmRepository, FilmService filmService){
        this.filmRepository = filmRepository;
        this.filmService = filmService;
    }

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

    @PostMapping(path = "/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("id")Long id, @RequestParam("photo") MultipartFile file) {
        try {
            filmService.saveFilmWithImage(id, file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

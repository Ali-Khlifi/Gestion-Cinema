package fr.uga.gestioncinema.web;

import fr.uga.gestioncinema.dao.FilmRepository;
import fr.uga.gestioncinema.entities.Film;
import fr.uga.gestioncinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

  /*  @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> readImages(@PathVariable(name = "id")Long id) throws IOException {
        byte[] image = filmService.readImages(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }*/

    @PostMapping(path = "/upload")
    public void uploadImage(@RequestParam("id")Long id, @RequestParam("photo") MultipartFile file) {
        Film film = filmService.getFilm(id);
        filmService.saveFilmWithImage(film, file);
    }
    @GetMapping("/imageFilm/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] image = filmService.getFilm(id).getPhoto();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
    }


}

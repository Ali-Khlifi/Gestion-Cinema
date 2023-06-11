package fr.uga.gestioncinema.web;

import fr.uga.gestioncinema.dao.FilmRepository;
import fr.uga.gestioncinema.entities.Film;
import fr.uga.gestioncinema.mappers.FilmMapper;
import fr.uga.gestioncinema.service.FilmService;
import fr.uga.gestioncinema.service.imp.FilmServiceImp;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.FilmApi;
import org.openapitools.model.FilmOpenApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class FilmController implements FilmApi {

    private final FilmService filmService;
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;


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
    @Override
    public ResponseEntity<FilmOpenApiModel> findOne (final Long id) {
        return ResponseEntity.ok().body(filmMapper.toOpenApiModel(filmService.fetchOne(id)));
    }

}

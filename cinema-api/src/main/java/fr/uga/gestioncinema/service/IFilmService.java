package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.entities.Film;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface IFilmService {
    byte [] readImages(Long id) throws IOException;
    void saveFilmWithImage(Long id, MultipartFile imageFile);


    Optional<Film> fetchOne(Long id);
}

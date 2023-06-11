package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.dto.FilmDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FilmService {
    byte [] readImages(Long id) throws IOException;
    void saveFilmWithImage(Long id, MultipartFile imageFile);

    FilmDto fetchOne(Long id);

}

package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.entities.Film;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFilmService {
    //byte [] readImages(Long id) throws IOException;
    Film saveFilmWithImage(Film film, MultipartFile imageFile);
}

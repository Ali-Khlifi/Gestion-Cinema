package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.dao.FilmRepository;
import fr.uga.gestioncinema.entities.Film;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilmService implements IFilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public byte[] readImages(Long id) throws IOException {
        Film f = filmRepository.findById(id).get();
        String photoName = f.getPhoto();
        //System.out.println(photoName);
        Resource imageResource = new ClassPathResource("static/images/" + photoName);
        try (InputStream inputStream = imageResource.getInputStream()) {
            return StreamUtils.copyToByteArray(inputStream);
        }
    }
}


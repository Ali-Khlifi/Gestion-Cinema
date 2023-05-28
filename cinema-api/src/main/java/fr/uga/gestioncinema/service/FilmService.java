package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.dao.FilmRepository;
import fr.uga.gestioncinema.entities.Film;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        // Build the file path
        String filePath = "D:/AutoFormations/AutoFormation_2023/Gestion-Cinema/cinema-api/images/" + photoName;
        // Read the file from the filesystem
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

    @Override
    @Transactional
    public void saveFilmWithImage(Long id, MultipartFile imageFile) {
        try {
            Film film = filmRepository.findById(id).get();
            String fileName = imageFile.getOriginalFilename();
            Path path = Paths.get("D:/AutoFormations/AutoFormation_2023/Gestion-Cinema/cinema-api/images/" + fileName);
            Files.write(path, imageFile.getBytes());
            film.setPhoto(fileName);
            filmRepository.save(film);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode permettant de convertir les images en byte
     */
}


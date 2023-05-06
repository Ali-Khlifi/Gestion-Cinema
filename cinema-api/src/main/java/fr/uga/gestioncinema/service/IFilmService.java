package fr.uga.gestioncinema.service;

import java.io.IOException;

public interface IFilmService {
    byte [] readImages(Long id) throws IOException;
}

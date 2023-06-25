package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.dto.CinemaDto;
import fr.uga.gestioncinema.dto.FilmDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CinemaService {
    CinemaDto fetchOne(Long id);
    CinemaDto save(@Valid CinemaDto dto);
    List<CinemaDto> fetchAll();
    CinemaDto update(@Valid CinemaDto dto);

    void delete(Long id);
}

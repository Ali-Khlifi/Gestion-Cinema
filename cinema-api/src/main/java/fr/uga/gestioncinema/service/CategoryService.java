package fr.uga.gestioncinema.service;

import fr.uga.gestioncinema.dto.CategoryDto;
import fr.uga.gestioncinema.dto.FilmDto;

public interface CategoryService {
    CategoryDto fetchOne(Long id);
}

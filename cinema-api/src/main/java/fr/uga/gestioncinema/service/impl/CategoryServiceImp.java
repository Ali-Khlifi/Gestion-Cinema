package fr.uga.gestioncinema.service.impl;

import fr.uga.gestioncinema.dao.CategorieRepository;
import fr.uga.gestioncinema.dto.CategoryDto;
import fr.uga.gestioncinema.exceptions.NotFoundException;
import fr.uga.gestioncinema.mappers.CategoryMapper;
import fr.uga.gestioncinema.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static fr.uga.gestioncinema.utils.StringUtils.Exceptions.NO_DATA;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategorieRepository categorieRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryDto fetchOne(Long id) {
        return categoryMapper.toDto(categorieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NO_DATA)));
    }
}

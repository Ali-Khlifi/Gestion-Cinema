package fr.uga.gestioncinema.mappers;

import fr.uga.gestioncinema.configurations.MapperConfig;
import fr.uga.gestioncinema.dto.CategoryDto;
import fr.uga.gestioncinema.dto.FilmDto;
import fr.uga.gestioncinema.entities.Category;
import fr.uga.gestioncinema.entities.Film;
import org.mapstruct.Mapper;
import org.openapitools.model.CategoryOpenApiModel;
import org.openapitools.model.FilmOpenApiModel;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {

    CategoryDto toDto(Category entity);

    CategoryOpenApiModel toOpenApiModel(CategoryDto dto);

}

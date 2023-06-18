package fr.uga.gestioncinema.mappers;

import fr.uga.gestioncinema.configurations.MapperConfig;
import fr.uga.gestioncinema.dto.CategoryDto;
import fr.uga.gestioncinema.dto.FilmDto;
import fr.uga.gestioncinema.entities.Category;
import fr.uga.gestioncinema.entities.Film;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.FilmOpenApiModel;

import java.util.List;
import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface FilmMapper {


    FilmDto toDto(Film filmEntity);
    Film toEntity(FilmDto filmDto);

    FilmDto toDto(FilmOpenApiModel model);

    FilmOpenApiModel toOpenApiModel(FilmDto filmDto);

    List<FilmOpenApiModel> toOpenApiModelList(List<FilmDto> listFilmDto);
    void update(@Valid FilmDto source, @MappingTarget Film target);


}

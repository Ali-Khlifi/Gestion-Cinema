package fr.uga.gestioncinema.mappers;

import fr.uga.gestioncinema.configurations.MapperConfig;
import fr.uga.gestioncinema.dto.FilmDto;
import fr.uga.gestioncinema.entities.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.FilmOpenApiModel;

import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface FilmMapper {


    FilmDto toDto(Film filmEntity);

    FilmOpenApiModel toOpenApiModel(FilmDto filmDto);


}

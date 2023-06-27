package fr.uga.gestioncinema.mappers;

import fr.uga.gestioncinema.configurations.MapperConfig;
import fr.uga.gestioncinema.dto.FilmProjectionDto;
import fr.uga.gestioncinema.entities.FilmProjection;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.openapitools.model.FilmProjectionOpenApiModel;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface FilmProjectionMapper {

    FilmProjectionDto toDto(FilmProjection entity);
    FilmProjection toEntity(FilmProjectionDto dto);

    FilmProjectionDto toDto(FilmProjectionOpenApiModel model);

    FilmProjectionOpenApiModel toOpenApiModel(FilmProjectionDto dto);

    List<FilmProjectionOpenApiModel> toOpenApiModelList(List<FilmProjectionDto> listFilmProjectionDto);
    void update(@Valid FilmProjectionDto source, @MappingTarget FilmProjection target);

}

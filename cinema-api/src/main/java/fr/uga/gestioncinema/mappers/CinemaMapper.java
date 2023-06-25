package fr.uga.gestioncinema.mappers;

import fr.uga.gestioncinema.configurations.MapperConfig;
import fr.uga.gestioncinema.dto.CinemaDto;
import fr.uga.gestioncinema.entities.Cinema;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.openapitools.model.CinemaOpenApiModel;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CinemaMapper {


    CinemaDto toDto(Cinema cinemaEntity);
    Cinema toEntity(CinemaDto cinemaDto);

    CinemaDto toDto(CinemaOpenApiModel model);

    CinemaOpenApiModel toOpenApiModel(CinemaDto cinemaDto);

    List<CinemaOpenApiModel> toOpenApiModelList(List<CinemaDto> listCinemaDto);
    void update(@Valid CinemaDto source, @MappingTarget Cinema target);


}

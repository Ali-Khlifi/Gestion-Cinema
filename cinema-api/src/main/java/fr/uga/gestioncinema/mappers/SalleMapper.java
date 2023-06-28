package fr.uga.gestioncinema.mappers;

import fr.uga.gestioncinema.configurations.MapperConfig;
import fr.uga.gestioncinema.dto.SalleDto;
import fr.uga.gestioncinema.entities.Salle;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.openapitools.model.SalleOpenApiModel;

import java.util.List;

@Mapper(config = MapperConfig.class, uses = {PlaceMapper.class, FilmProjectionMapper.class})
public interface SalleMapper {

    SalleDto toDto(Salle salleEntity);
    Salle toEntity(SalleDto dto);

    SalleDto toDto(SalleOpenApiModel model);

    SalleOpenApiModel toOpenApiModel(SalleDto dto);

    List<SalleOpenApiModel> toOpenApiModelList(List<SalleDto> listSalleDto);
    void update(@Valid SalleDto source, @MappingTarget Salle target);

}

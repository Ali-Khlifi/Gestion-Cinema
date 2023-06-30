package fr.uga.gestioncinema.mappers;

import fr.uga.gestioncinema.configurations.MapperConfig;
import fr.uga.gestioncinema.dto.TicketDto;
import fr.uga.gestioncinema.entities.Ticket;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.openapitools.model.TicketOpenApiModel;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface TicketMapper {

    TicketDto toDto(Ticket entity);
    Ticket toEntity(TicketDto dto);

    TicketDto toDto(TicketOpenApiModel model);

    TicketOpenApiModel toOpenApiModel(TicketDto dto);

    List<TicketOpenApiModel> toOpenApiModelList(List<TicketDto> listTicketDto);
    void update(@Valid TicketDto source, @MappingTarget Ticket target);


}

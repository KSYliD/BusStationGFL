package com.example.busstationgfl.mappers;

import com.example.busstationgfl.dtos.journey.JourneyDto;
import com.example.busstationgfl.entities.journey.Journey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JourneyMapper {
    JourneyDto journeyToDto(Journey journey);
    Journey DtoToJourney(JourneyDto journeyDto);
}

package com.example.busstationgfl.mappers;

import com.example.busstationgfl.dtos.journey.bus.BusDto;
import com.example.busstationgfl.entities.bus.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusMapper {
    BusDto busToDto(Bus bus);
    Bus DtoToBus(BusDto busDto);
}

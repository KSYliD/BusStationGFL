package com.example.busstationgfl.services.classes.bus;

import com.example.busstationgfl.dtos.journey.bus.BusDto;
import com.example.busstationgfl.entities.bus.BusType;
import com.example.busstationgfl.mappers.BusMapper;
import com.example.busstationgfl.repositories.BusRepository;
import com.example.busstationgfl.services.interfaces.bus.BusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusServiceImpl implements BusService {
    private BusRepository busRepository;
    private BusMapper busMapper;

    @Override
    public List<BusDto> findAll() {
        return busRepository.findAll().stream().map(busMapper::busToDto).collect(Collectors.toList());
    }

    @Override
    public BusDto findById(long id) {
        return busMapper.busToDto(busRepository.findById(id));
    }
    @Override
    public BusDto save(BusDto bus){
        return busMapper.busToDto(busRepository.save(busMapper.DtoToBus(bus)));
    }

    @Override
    public List<BusType> bysTypes() {
        return Arrays.stream(BusType.values()).toList();
    }

}

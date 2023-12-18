package com.example.busstationgfl.services.classes.journey;

import com.example.busstationgfl.dtos.journey.JourneyDto;
import com.example.busstationgfl.mappers.JourneyMapper;
import com.example.busstationgfl.repositories.JourneyRepository;
import com.example.busstationgfl.services.interfaces.journey.JourneyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JourneyServiceImpl implements JourneyService {
    private JourneyRepository journeyRepository;
    private JourneyMapper journeyMapper;

    @Override
    public List<JourneyDto> findAll() {
        return journeyRepository.findAll().stream().map(journeyMapper::journeyToDto).collect(Collectors.toList());
    }

    @Override
    public JourneyDto getJourneyById(long id) {
        return journeyMapper.journeyToDto(journeyRepository.findById(id));
    }

    @Override
    public JourneyDto save(JourneyDto journey) {

        return journeyMapper.journeyToDto(journeyRepository.save(journeyMapper.DtoToJourney(journey)));
    }

    @Override
    public void deleteJourneyById(Long id) {
        journeyRepository.deleteJourneyById(id);
    }
}

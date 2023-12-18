package com.example.busstationgfl.controllers;

import com.example.busstationgfl.dtos.journey.bus.SeatDto;
import com.example.busstationgfl.dtos.requests.BuyTicketRequestDto;
import com.example.busstationgfl.dtos.requests.GenerateSeatsRequestDto;
import com.example.busstationgfl.dtos.requests.ReturnTicketRequestDto;
import com.example.busstationgfl.entities.bus.Status;
import com.example.busstationgfl.services.interfaces.bus.SeatService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/seats")
@Log4j2
public class SeatController {
    private SeatService seatService;

    @GetMapping("/{id}")
    List<SeatDto> findSeatsByBusId(@PathVariable("id") long id) {
        return seatService.findSeatsByBusId(id);
    }

    @GetMapping("/{id}/{journeyId}")
    List<SeatDto> findAllByBusIdAndJourneyId(@PathVariable("id") long id,
                                             @PathVariable("journeyId") long journeyId){
        return seatService.findAllByBusIdAndJourneyId(id, journeyId);
    }

    @GetMapping("/{status}/{id}/{journeyId}")
    public int countSeatByStatusAndBus_Id(@PathVariable("status") Status status,
                                          @PathVariable("id") long id,
                                          @PathVariable("journeyId") long journeyId) {
        return seatService.countSeatByStatusAndBusIdAndJourneyId(status, id, journeyId);
    }

    @PostMapping("/buy")
    SeatDto buySeatWithIdByUser(@RequestBody BuyTicketRequestDto buyRequestDto,
                             @AuthenticationPrincipal UserDetails userDetails) {
        return seatService.buyTheSeat(buyRequestDto, userDetails);
    }

    @PostMapping("/return")
    SeatDto returnTheTicket(@RequestBody ReturnTicketRequestDto returnTheTicketRequest) {
        return seatService.returnTheTicket(returnTheTicketRequest);
    }
    @PostMapping("/generateSeats")
    List<SeatDto> generateSeats(@RequestBody GenerateSeatsRequestDto generateSeatsRequestDto){
        log.info(generateSeatsRequestDto);
        return seatService.generateSeats(generateSeatsRequestDto);
    }
}

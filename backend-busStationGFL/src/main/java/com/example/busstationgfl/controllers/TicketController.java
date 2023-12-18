package com.example.busstationgfl.controllers;

import com.example.busstationgfl.dtos.journey.TicketDto;
import com.example.busstationgfl.dtos.requests.TicketRequestDTO;
import com.example.busstationgfl.entities.TicketStatus;
import com.example.busstationgfl.services.interfaces.TicketService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/tickets")
@Log4j2
public class TicketController {

    private TicketService ticketService;

    @GetMapping("/{ticketStatus}")
    List<TicketDto> findAllByUserIdAndTicketStatus(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("ticketStatus") TicketStatus ticketStatus) {
        return ticketService.findAllByUserIdAndTicketStatus(userDetails, ticketStatus);
    }

    @GetMapping("/id/{id}")
    TicketDto findById(@PathVariable("id") long id) {
        return ticketService.findById(id);
    }

    @PostMapping
    TicketDto save(@RequestBody TicketRequestDTO ticketRequestDTO,
                @AuthenticationPrincipal UserDetails userDetails) {
        return ticketService.save(ticketRequestDTO, userDetails);
    }
}

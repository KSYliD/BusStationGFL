package com.example.busstationgfl.dtos.requests;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyTicketRequestDto {
    private long number;
    private long journeyId;
}


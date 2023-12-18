package com.example.busstationgfl.dtos.requests;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnTicketRequestDto {
    private long number;
    private long journeyId;
}

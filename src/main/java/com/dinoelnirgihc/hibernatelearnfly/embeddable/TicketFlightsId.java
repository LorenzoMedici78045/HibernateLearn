package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketFlightsId implements Serializable
{
    @Column(name = "TICKET_NO")
    private Long ticketId;

    @Column(name = "FLIGHT_ID")
    private Long flightId;
}

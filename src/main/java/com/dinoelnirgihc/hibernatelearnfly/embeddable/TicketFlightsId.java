package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
    @Size(max = 13)
    @Column(name = "TICKET_NO")
    private String ticketNumber;

    @Column(name="FLIGHT_ID")
    private Integer id;
}

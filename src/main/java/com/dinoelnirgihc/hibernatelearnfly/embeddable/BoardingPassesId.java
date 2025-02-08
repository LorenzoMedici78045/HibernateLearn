package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import com.dinoelnirgihc.hibernatelearnfly.entity.Tickets;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardingPassesId implements Serializable
{
    @Column(name = "TICKET_NO")
    private Long ticketId;

    @Column(name = "FLIGHT_ID")
    private Long flightId;


}

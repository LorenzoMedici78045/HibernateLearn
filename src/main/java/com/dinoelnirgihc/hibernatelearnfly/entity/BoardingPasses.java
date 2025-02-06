package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.BoardingPassesId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 Класс ПосадочныеТалоны отражает сущность BOARDING_PASSES.
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BOARDING_PASSES")
public class BoardingPasses implements Serializable
{
    @EmbeddedId
    private BoardingPassesId id;

    @Column(name = "BOARDING_NO", nullable = false)
    private Long boardingNumber;

    @Column(name = "SEAT_NO", nullable = false)
    private Long seatNumber;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "TICKET_NO",
                    insertable=false, updatable=false),
            @JoinColumn(name= "FLIGHT_ID",
                    insertable=false, updatable=false)
    })
    private TicketFlights ticket;
}


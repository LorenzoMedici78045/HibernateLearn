package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.BoardingPassesId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 Класс ПосадочныеТалоны отражает сущность BOARDING_PASSES.
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BOARDING_PASSES", schema = "bookings")
public class BoardingPasses implements Serializable
{
    @EmbeddedId
    private BoardingPassesId id;

    @Column(name = "BOARDING_NO")
    private Integer boardingNumber;

    @Column(name = "SEATS_NO")
    private String seatsNumber;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "TICKET_NO",
                    insertable=false, updatable=false),
            @JoinColumn(name= "FLIGHT_ID",
                    insertable=false, updatable=false)
    })
    private TicketFlights ticket;
}


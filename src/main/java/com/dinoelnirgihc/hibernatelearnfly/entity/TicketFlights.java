package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.TicketFlightsId;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Класс Перелеты отражает сущность TICKET_FLIGHTS.
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TICKET_FLIGHTS")
public class TicketFlights implements Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "ticketId", column = @Column(name = "TICKET_NO")),
            @AttributeOverride(name = "flightId", column = @Column(name = "FLIGHT_ID"))
    })
    private TicketFlightsId ticketFlightsId;

    @ManyToOne
    @JoinColumn(name = "TICKET_NO"/*referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //TICKET_NO
    private Tickets ticket;

    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID"/*referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //FLIGHT_ID
    private Flights flight;

    @Column(name = "FARE_CONDITIONS", nullable = false)
    @Enumerated(EnumType.STRING)
    private fareConditionsType fareConditions;

    @Column(name = "AMOUNT", nullable = false)
    @Size(max = 10)
    private BigDecimal amount;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<BoardingPasses> boardingPasses = new ArrayList<>();

}

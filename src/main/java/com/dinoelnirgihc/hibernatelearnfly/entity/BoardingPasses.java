package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.BoardingPassesId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;

/**
 Класс ПосадочныеТалоны отражает сущность BOARDING_PASSES.
 * */
@Entity
@Data
@AllArgsConstructor
@NamedEntityGraph(
       name = "withTickFlight",
        attributeNodes = {
               @NamedAttributeNode(value = "ticket")
        }
)
@NoArgsConstructor
@Builder
@Audited
@Table(name = "BOARDING_PASSES")
public class BoardingPasses implements Serializable
{
    @EmbeddedId
    private BoardingPassesId id;

    @Column(name = "BOARDING_NO", nullable = false)
    private Long boardingNumber;

    @Column(name = "SEAT_NO", nullable = false)
    private Long seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotAudited
    @JoinColumns({
            @JoinColumn(name = "TICKET_NO",
                    insertable=false, updatable=false),
            @JoinColumn(name= "FLIGHT_ID",
                    insertable=false, updatable=false)
    })
    private TicketFlights ticket;
}


package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 Класс Билеты отражает сущность Tickets. Отражает информацию о билетах.
 * */
@NamedEntityGraph(
        name = "withTicketFlightandBoarPass",
        attributeNodes = {@NamedAttributeNode(value = "ticketFlights", subgraph = "tickFly")},
        subgraphs = {@NamedSubgraph(name = "tickFly", attributeNodes = @NamedAttributeNode("boardingPasses"))}
)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited
@Table(name = "TICKETS")
public class Tickets implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TICKET_NO")
    private Long id;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_REF"/*referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //BOOK_REF
    private Bookings bookings;

    @Embedded
    @AttributeOverrides(
            {@AttributeOverride(name = "password", column = @Column(name = "PASSENGER_ID")),
                    @AttributeOverride(name = "name", column = @Column(name = "PASSENGER_NAME")),
                    @AttributeOverride(name = "contactData", column = @Column(name = "CONTACT_DATA"))})
    private User user;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_REF"/*referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //BOOKINGS_BOOK_REF
    private Bookings bookingsBook;

    @NotAudited
    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<TicketFlights> ticketFlights = new ArrayList<>();

    public void addTicketFlights(TicketFlights ticketFlight)
    {
        this.ticketFlights.add(ticketFlight);
        ticketFlight.setTicket(this);
    }
}

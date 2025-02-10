package com.dinoelnirgihc.hibernatelearnfly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Класс Бронирования отражает сущность  bookings. Содержит информацию о дате, времени и стоимости полета*/
@NamedEntityGraph(
        name = "withTicketList",
        attributeNodes = {@NamedAttributeNode(value = "ticketsList", subgraph = "tickets")},
        subgraphs = {@NamedSubgraph(name = "tickets", attributeNodes = @NamedAttributeNode("ticketFlights"))}
)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited
@Table(name = "BOOKINGS")
public class Bookings  implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BOOK_REF")
    private Long id;

    @Column(name = "BOOK_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp bookDate;

    @Column(name="TOTAL_AMOUNT", nullable = false)
    @Size(max = 10)
    private BigDecimal totalAmount;

    @NotAudited
    @OneToMany(mappedBy = "bookings",fetch = FetchType.LAZY)
    private List<Tickets> ticketsList = new ArrayList<>();

    @NotAudited
    @OneToMany(mappedBy = "bookingsBook",fetch = FetchType.LAZY)
    private List<Tickets> ticketsListLists = new ArrayList<>();

}

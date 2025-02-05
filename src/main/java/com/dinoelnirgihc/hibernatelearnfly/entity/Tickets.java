package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 Класс Билеты отражает сущность Tickets. Отражает информацию о билетах.
 * */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TICKETS", schema = "bookings")
public class Tickets implements Serializable
{
    @Id
    @Column(name = "TICKET_NO")
    @Size(max = 255)
    private String id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_REF"/*referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //BOOKINGS_BOOK_REF
    private Bookings bookingsBook;



}

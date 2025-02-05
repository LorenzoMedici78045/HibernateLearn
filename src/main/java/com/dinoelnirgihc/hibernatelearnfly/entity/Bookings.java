package com.dinoelnirgihc.hibernatelearnfly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/** Класс Бронирования отражает сущность  bookings. Содержит информацию о дате, времени и стоимости полета*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BOOKINGS", schema = "bookings")
public class Bookings  implements Serializable
{
    @Id
    @Column(name = "BOOK_REF")
    @Size(max = 6)
    private String id;

    @Column(name = "BOOK_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp bookDate;

    @Column(name="TOTAL_AMOUNT", nullable = false)
    @Size(max = 10)
    private BigDecimal totalAmount;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Tickets> TicketsList = new HashSet<Tickets>();

}

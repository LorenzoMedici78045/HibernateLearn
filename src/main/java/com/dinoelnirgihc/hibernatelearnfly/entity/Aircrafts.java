package com.dinoelnirgihc.hibernatelearnfly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Класс Самолеты отражает сущность  aircrafts. Содержит информацию о модели и дальности ее перелета*/

@NamedEntityGraph(
        name = "withFlight",
        attributeNodes = {@NamedAttributeNode(value = "flights", subgraph = "airport")}
        ,subgraphs = {@NamedSubgraph(name = "airport", attributeNodes = @NamedAttributeNode("airportArrival"))}
)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "AIRCRAFTS")
@Audited
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Aircrafts implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AIRCRAFT_CODE")
    private Long id;

    @Version
    private Long version;

    @Column(name = "MODEL", nullable = false)
    @NotBlank
    private String model;

    @Column(name = "RANGE", nullable = false)
    private int range;

    @NotAudited
    @OneToMany(mappedBy = "aircrafts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Flights> flights = new ArrayList<>();

    @NotAudited
    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seats> seats = new ArrayList<>();

    @NotAudited
    @OneToMany(mappedBy = "aircraftAircraft", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seats> seatsSeats = new ArrayList<>();

    public void addSeats(Seats seat)
    {
        this.seats.add(seat);
        seat.setAircraft(this);
    }
}

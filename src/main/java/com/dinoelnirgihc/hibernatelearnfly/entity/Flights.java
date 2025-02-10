package com.dinoelnirgihc.hibernatelearnfly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Класс Перелеты отражает сущность Flights.*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Audited
@Table(name = "FLIGHTS")
public class Flights implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FLIGHT_ID")
    private Long id;

    @Column(name = "FLIGHT_NO",nullable = false)
    @NotBlank
    private String flightNumber;

    @Column(name = "SCHEDULED_DEPARTURE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp scheduledDeparture;

    @Column(name = "SCHEDULED_ARRIVAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp scheduledArrival;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRPORT_CODE"/*referencedColumnName = "airportCode"*/,
            insertable=false, updatable=false)
    private Airports airportDeparture;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRPORT_CODE"/*referencedColumnName = "airportCode"*/,
            insertable=false, updatable=false)
    private Airports airportArrival;

    @Column(name = "STATUS")
    @Size(max = 20)
    private String status;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRCRAFT_CODE"/* referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //AIRCRAFT_CODE
    private Aircrafts aircrafts;

    @Column(name = "ACTUAL_DEPARTURE")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp actualDeparture;

    @Column(name = "ACTUAL_ARRIVAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp actualArrival;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRPORT_CODE"/*referencedColumnName = "airportCode"*/,
            insertable=false, updatable=false)
    //AIRPORTARRIVAL_AIRPORT_CODE
    private Airports airportArrivalCode;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRPORT_CODE"/*referencedColumnName = "airportCode"*/,
            insertable=false, updatable=false)
    //AIRPORTDEPARTURE_AIRPORT_CODE
    private Airports airportDepartureCode;

    @NotAudited
    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<TicketFlights> ticketsFlight = new ArrayList<>();
}

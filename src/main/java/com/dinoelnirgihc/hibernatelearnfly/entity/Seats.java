package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.SeatsId;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** Класс Места отражает сущность  seats.*/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "SEATS", schema = "bookings")
public class Seats implements Serializable
{
    @EmbeddedId
    private SeatsId id;

    @Column(name = "FARE_CONDITIONS", nullable = false)
    @Enumerated(EnumType.STRING)
    private fareConditionsType fareConditions;

    @ManyToOne
    @JoinColumn(name = "AIRCRAFT_CODE"/*referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //AIRCRAFT_CODE
    private Aircrafts aircraft;

    @ManyToOne
    @JoinColumn(name = "AIRCRAFT_CODE"/*referencedColumnName = "id"*/,
            insertable=false, updatable=false)
    //AIRCRAFT_AIRCRAFT_CODE
    private Aircrafts aircraftAircraft;



}

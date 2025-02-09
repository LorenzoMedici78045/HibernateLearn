package com.dinoelnirgihc.hibernatelearnfly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Класс Самолеты отражает сущность  aircrafts. Содержит информацию о модели и дальности ее перелета*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "AIRCRAFTS")
public class Aircrafts implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AIRCRAFT_CODE")
    private Long id;

    @Column(name = "MODEL", nullable = false)
    @NotBlank
    private String model;

    @Column(name = "RANGE", nullable = false)
    private int range;

    @OneToMany(mappedBy = "aircrafts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Flights> flights = new ArrayList<>();

    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seats> seats = new ArrayList<>();

    @OneToMany(mappedBy = "aircraftAircraft", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seats> seatsSeats = new ArrayList<>();

    public void addSeats(Seats seat)
    {
        this.seats.add(seat);
        seat.setAircraft(this);
    }
}

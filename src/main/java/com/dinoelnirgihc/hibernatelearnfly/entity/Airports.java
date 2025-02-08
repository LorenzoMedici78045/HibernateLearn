package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.converter.CityConverter;
import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс Аиропорты отражает сущность Airports. Отражает информацию о аэропортах.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "AIRPORTS")
public class Airports implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AIRPORT_CODE")
    private Long id;

    @Column(name = "AIRPORT_NAME", nullable = false)
    private String name;

    @Column(name = "CITY", nullable = false)
    @Convert(converter = CityConverter.class)
    private City city;

    @Column(name="LONGITUDE", nullable = false)
    private double longitude;

    @Column(name="LATITUDE", nullable = false)
    private double latitude;

    @Column(name="TIMEZONE", nullable = false)
    @Pattern(regexp = ".*[/]].*", message = "Use timezone form")
    private String timezone;

    @OneToMany(mappedBy = "airportArrival" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> arrivalFlights = new ArrayList<>();

    @OneToMany(mappedBy = "airportDeparture" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> departureFlights = new ArrayList<>();

    @OneToMany(mappedBy = "airportArrivalCode" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> arrivalFlightsCode = new ArrayList<>();

    @OneToMany(mappedBy = "airportDepartureCode" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> departureFlightsCode = new ArrayList<>();
}

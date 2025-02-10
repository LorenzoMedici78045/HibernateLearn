package com.dinoelnirgihc.hibernatelearnfly.entity;

import com.dinoelnirgihc.hibernatelearnfly.converter.CityConverter;
import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

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
@Audited
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "Airports")
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Airports implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AIRPORT_CODE")
    private Long id;

    @Version
    private long version;

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

    @NotAudited
    @OneToMany(mappedBy = "airportArrival" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> arrivalFlights = new ArrayList<>();

    @NotAudited
    @OneToMany(mappedBy = "airportDeparture" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> departureFlights = new ArrayList<>();

    @NotAudited
    @OneToMany(mappedBy = "airportArrivalCode" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> arrivalFlightsCode = new ArrayList<>();

    @NotAudited
    @OneToMany(mappedBy = "airportDepartureCode" ,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Flights> departureFlightsCode = new ArrayList<>();
}

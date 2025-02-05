package com.dinoelnirgihc.hibernatelearnfly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/** Класс Самолеты отражает сущность  aircrafts. Содержит информацию о модели и дальности ее перелета*/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "AIRCRAFTS", schema = "bookings")
public class Aircrafts implements Serializable
{
    @Id
    @Column(name = "AIRCRAFT_CODE")
    @Size(max = 3)
    private String id;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "RANGE", nullable = false)
    private int range;

    @OneToMany(mappedBy = "aircrafts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Flights> flights = new HashSet<>();
}

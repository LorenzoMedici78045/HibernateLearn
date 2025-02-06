package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class SeatsId
{
    @Column(name = "AIRCRAFT_CODE")
    private Long aircraftId;

    @Column(name = "SEAT_NO", nullable = false)
    private Long seatNumber;

}

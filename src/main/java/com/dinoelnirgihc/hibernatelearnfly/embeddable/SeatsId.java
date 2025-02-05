package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class SeatsId
{
    @Column(name = "AIRCRAFT_CODE", nullable = false)
    @Size(max = 3)
    private String id;

    @Column(name = "SEAT_NO", nullable = false)
    private String seatNumber;

}

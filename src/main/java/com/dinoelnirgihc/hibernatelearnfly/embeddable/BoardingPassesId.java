package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import com.dinoelnirgihc.hibernatelearnfly.entity.Tickets;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@AllArgsConstructor
@Data
public class BoardingPassesId
{

    @Size(max = 13)
    @Column(name = "TICKET_NO")
    private String ticketNumber;

    @Column(name="FLIGHT_ID")
    private Integer id;


}

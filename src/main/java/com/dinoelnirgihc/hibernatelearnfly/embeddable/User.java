package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import com.dinoelnirgihc.hibernatelearnfly.converter.ContactDataConverter;
import com.dinoelnirgihc.hibernatelearnfly.converterClasses.ContactData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
/** Embeddable класс класса-сущности Tickets*/
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    @Column(name = "PASSENGER_ID", nullable = false)
    @UniqueElements
    private String password;

    @Column(name = "PASSENGER_NAME", nullable = false)
    private String name;


    @Column(name = "CONTACT_DATA", nullable = true)
    @Convert(converter = ContactDataConverter.class)
    private ContactData contactData;

}

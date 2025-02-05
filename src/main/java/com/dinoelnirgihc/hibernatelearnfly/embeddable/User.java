package com.dinoelnirgihc.hibernatelearnfly.embeddable;

import com.dinoelnirgihc.hibernatelearnfly.json.ContactData;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.UniqueElements;
/** Embeddable класс класса-сущности Tickets*/
@Data
@AllArgsConstructor
@Embeddable
public class User
{
    @Column(name = "PASSENGER_ID", nullable = false)
    @UniqueElements
    private String password;

    @Column(name = "PASSENGER_NAME", nullable = false)
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "CONTACT_DATA", nullable = true)
    private ContactData contactData;

}

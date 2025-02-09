package com.dinoelnirgihc.hibernatelearnfly.converter;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.ContactData;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class ContactDataConverter  implements AttributeConverter<ContactData, String>
{
    @Override
    public String convertToDatabaseColumn(ContactData contactData) {
        return Optional.ofNullable(contactData)
                .map(ContactData::createInfo)
                .orElse(null);
    }

    @Override
    public ContactData convertToEntityAttribute(String dbData) {
        String[] data = dbData.split(" ");

        return ContactData.builder().email(data[1]).phone(data[3]).build();
    }
}

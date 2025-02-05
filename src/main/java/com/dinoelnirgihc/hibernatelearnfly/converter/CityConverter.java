package com.dinoelnirgihc.hibernatelearnfly.converter;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

/**Учебный класс-конвертера */
@Converter(autoApply = true)
public class CityConverter implements AttributeConverter<City, String>
{

    @Override
    public String convertToDatabaseColumn(City attribute) {
        return Optional.ofNullable(attribute)
                .map(City::getName)
                .orElse(null);
    }

    @Override
    public City convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData)
                .map(City::new)
                .orElse(null);
    }
}

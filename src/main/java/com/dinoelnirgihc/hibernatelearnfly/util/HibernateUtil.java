package com.dinoelnirgihc.hibernatelearnfly.util;

import com.dinoelnirgihc.hibernatelearnfly.converter.CityConverter;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil
{
    public static SessionFactory buildSessionFactory()
    {
        Configuration cfg = buildConfiguration();
        cfg.configure();
        
        return cfg.buildSessionFactory();
    }

    public static Configuration buildConfiguration()
    {
        Configuration cfg = new Configuration();
        cfg.addAttributeConverter(CityConverter.class);

        return cfg;
    }

}

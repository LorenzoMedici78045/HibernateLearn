package com.dinoelnirgihc.hibernatelearnfly.util;

import com.dinoelnirgihc.hibernatelearnfly.converter.CityConverter;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PreDeleteEventListener;
import org.hibernate.internal.SessionFactoryImpl;

@UtilityClass
public class HibernateUtil
{
    public static SessionFactory buildSessionFactory()
    {
        Configuration cfg = buildConfiguration();
        cfg.configure();
        var sessionFactory = cfg.buildSessionFactory();

        return sessionFactory;
    }

    public static Configuration buildConfiguration()
    {
        Configuration cfg = new Configuration();
        cfg.addAttributeConverter(CityConverter.class);
        return cfg;
    }

}

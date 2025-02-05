package com.dinoelnirgihc.hibernatelearnfly;

import com.dinoelnirgihc.hibernatelearnfly.converter.CityConverter;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateRunner
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration().configure();
        cfg.addAttributeConverter(CityConverter.class);
        try(SessionFactory sessionFactory = cfg.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Aircrafts a1 = session.get(Aircrafts.class, "733");
            System.out.println(a1.getModel());
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}

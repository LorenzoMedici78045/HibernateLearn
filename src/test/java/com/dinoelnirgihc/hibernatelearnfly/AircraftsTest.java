package com.dinoelnirgihc.hibernatelearnfly;

import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class AircraftsTest
{
    @Test
    public void crudAircraft()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            Aircrafts a1 = session.get(Aircrafts.class, 1L);
            a1.setModel("Boing");
            session.merge(a1);
            session.delete(a1);
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}

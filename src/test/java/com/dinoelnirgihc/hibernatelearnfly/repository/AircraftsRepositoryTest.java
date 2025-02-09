package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AircraftsRepositoryTest
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


    @Test
    void findAllAircrafts()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.findAllAircrafts(session);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectModelById()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectModelById(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectRangeById()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectRangeById(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAircraftsByRangeMore()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectAircraftsByRangeMore(session, 7000);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAircraftsBYModelName()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectAircraftsBYModelName(session, "Airbus");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllAircraftsCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.findAllAircraftsCriteria(session);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectModelByIdCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectModelByIdCriteria(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectRangeByIdCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectRangeByIdCriteria(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAircraftsByRangeMoreCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectAircraftsByRangeMoreCriteria(session, 7000);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAircraftsBYModelNameCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectAircraftsBYModelNameCriteria(session, "Airbus");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllAircraftsQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.findAllAircraftsQueryDsl(session);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectModelByIdCQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectModelByIdQueryDsl(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectRangeByIdQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectRangeByIdQueryDsl(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAircraftsByRangeMoreQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectAircraftsByRangeMoreQueryDsl(session, 7000);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAircraftsBYModelNameQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();
            session.persist(aircraft);
            AircraftsRepository airRep = new AircraftsRepository();
            airRep.selectAircraftsBYModelNameQueryDsl(session, "Airbus");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
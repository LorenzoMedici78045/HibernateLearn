package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.entity.Airports;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportsRepositoryTest {

    @Test
    public void crudAirports()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            Airports air1 = session.get(Airports.class, 1L);
            airport.setCity(new City("Omsk"));
            session.merge(air1);
            session.delete(air1);
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
    void selectAllAirports()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirports(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void returnAirportByName()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.returnAirportByName(session, "Lozovo");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByTimezone()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByTimezone(session, "Russia/Moscow");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByTimezoneMax()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByTimezoneMax(session, "Russia/Moscow", 5);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByCity()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByCity(session, airport.getCity());
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsCriteria(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void returnAirportByNameCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.returnAirportByNameCriteria(session, "Lozovo");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByTimezoneCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByTimezoneCriteria(session, "Russia/Moscow");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByTimezoneMaxCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByTimezoneMaxCriteria(session, "Russia/Moscow", 5);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByCityCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByCityCriteria(session, airport.getCity());
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsQueryDsl(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void returnAirportByNameQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.returnAirportByNameQueryDsl(session, "Lozovo");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByTimezoneQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByTimezoneQueryDsl(session, "Russia/Moscow");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByTimezoneMaxQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByTimezoneMaxQueryDsl(session, "Russia/Moscow", 5);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void selectAllAirportsByCityQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            AirportsRepository AR = new AirportsRepository();
            Airports airport = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();
            session.persist(airport);
            AR.selectAllAirportsByCityQueryDsl(session, airport.getCity());
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
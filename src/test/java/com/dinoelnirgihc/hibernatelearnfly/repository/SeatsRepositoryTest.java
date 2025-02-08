package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.SeatsId;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.entity.Seats;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatsRepositoryTest {

    @Test
    public void crudSeats()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Aircrafts aircraft1 = Aircrafts.builder().model("Airbus").range(7500).build();
            Aircrafts aircraft2 = Aircrafts.builder().model("Airbus").range(10500).build();

            Seats seats = Seats.builder()
                    .id(new SeatsId(1L, 1L))
                    .aircraft(aircraft1)
                    .aircraftAircraft(aircraft2)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .build();

            session.persist(aircraft1);
            session.persist(aircraft2);
            session.persist(seats);
            Seats seats1 = session.get(Seats.class, new SeatsId(1L, 1L));
            seats1.setFareConditions(fareConditionsType.ECONOMY);
            session.merge(seats1);
            session.delete(seats1);
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
    void findallSeats()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            SeatsRepository sR = new SeatsRepository();
            Aircrafts aircraft1 = Aircrafts.builder().model("Airbus").range(7500).build();
            Aircrafts aircraft2 = Aircrafts.builder().model("Airbus").range(10500).build();

            Seats seats = Seats.builder()
                    .id(new SeatsId(1L, 1L))
                    .aircraft(aircraft1)
                    .aircraftAircraft(aircraft2)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .build();

            session.persist(aircraft1);
            session.persist(aircraft2);
            session.persist(seats);
            sR.findallSeats(session);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllSeatByFareCond()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            SeatsRepository sR = new SeatsRepository();
            Aircrafts aircraft1 = Aircrafts.builder().model("Airbus").range(7500).build();
            Aircrafts aircraft2 = Aircrafts.builder().model("Airbus").range(10500).build();

            Seats seats = Seats.builder()
                    .id(new SeatsId(1L, 1L))
                    .aircraft(aircraft1)
                    .aircraftAircraft(aircraft2)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .build();

            session.persist(aircraft1);
            session.persist(aircraft2);
            session.persist(seats);
            sR.findAllSeatByFareCond(session, fareConditionsType.BUSINESS);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllSeatByAircraftId()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            SeatsRepository sR = new SeatsRepository();
            Aircrafts aircraft1 = Aircrafts.builder().model("Airbus").range(7500).build();
            Aircrafts aircraft2 = Aircrafts.builder().model("Airbus").range(10500).build();

            Seats seats = Seats.builder()
                    .id(new SeatsId(1L, 1L))
                    .aircraft(aircraft1)
                    .aircraftAircraft(aircraft2)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .build();

            session.persist(aircraft1);
            session.persist(aircraft2);
            session.persist(seats);
            sR.findAllSeatByAircraftId(session, 1L);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
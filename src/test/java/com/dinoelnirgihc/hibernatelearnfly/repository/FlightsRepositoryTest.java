package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.entity.Airports;
import com.dinoelnirgihc.hibernatelearnfly.entity.Flights;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FlightsRepositoryTest {

    @Test
    public void crudFlights()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            Airports a1 = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Pradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();

            Airports a2 = Airports.builder()
                    .name("Lozavo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Mascow")
                    .build();

            Airports a3 = Airports.builder()
                    .name("Pozovo")
                    .city(new City("Grads"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusia/Moscow")
                    .build();

            Airports a4 = Airports.builder()
                    .name("Ltzovo")
                    .city(new City("Graesk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusqia/Moscow")
                    .build();

            Flights f1 = Flights.builder()
                    .flightNumber("75463")
                    .scheduledArrival(new Timestamp(new Date().getTime()))
                    .scheduledDeparture(new Timestamp(new Date().getTime()))
                    .actualArrival(new Timestamp(new Date().getTime()))
                    .actualDeparture(new Timestamp(new Date().getTime()))
                    .status("true")
                    .airportArrival(a1)
                    .airportArrivalCode(a2)
                    .airportDeparture(a3)
                    .airportDepartureCode(a4)
                    .aircrafts(aircraft)
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            Flights fli1 = session.get(Flights.class,1L);
            fli1.setFlightNumber("456734");
            session.merge(fli1);
            session.delete(fli1);
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
    void findAllFlights()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            FlightsRepository FR = new FlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            Airports a1 = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Pradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();

            Airports a2 = Airports.builder()
                    .name("Lozavo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Mascow")
                    .build();

            Airports a3 = Airports.builder()
                    .name("Pozovo")
                    .city(new City("Grads"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusia/Moscow")
                    .build();

            Airports a4 = Airports.builder()
                    .name("Ltzovo")
                    .city(new City("Graesk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusqia/Moscow")
                    .build();

            Flights f1 = Flights.builder()
                    .flightNumber("75463")
                    .scheduledArrival(new Timestamp(new Date().getTime()))
                    .scheduledDeparture(new Timestamp(new Date().getTime()))
                    .actualArrival(new Timestamp(new Date().getTime()))
                    .actualDeparture(new Timestamp(new Date().getTime()))
                    .status("true")
                    .airportArrival(a1)
                    .airportArrivalCode(a2)
                    .airportDeparture(a3)
                    .airportDepartureCode(a4)
                    .aircrafts(aircraft)
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            FR.findAllFlights(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findFlightByFlightNumber()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            FlightsRepository FR = new FlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            Airports a1 = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Pradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();

            Airports a2 = Airports.builder()
                    .name("Lozavo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Mascow")
                    .build();

            Airports a3 = Airports.builder()
                    .name("Pozovo")
                    .city(new City("Grads"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusia/Moscow")
                    .build();

            Airports a4 = Airports.builder()
                    .name("Ltzovo")
                    .city(new City("Graesk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusqia/Moscow")
                    .build();

            Flights f1 = Flights.builder()
                    .flightNumber("75463")
                    .scheduledArrival(new Timestamp(new Date().getTime()))
                    .scheduledDeparture(new Timestamp(new Date().getTime()))
                    .actualArrival(new Timestamp(new Date().getTime()))
                    .actualDeparture(new Timestamp(new Date().getTime()))
                    .status("true")
                    .airportArrival(a1)
                    .airportArrivalCode(a2)
                    .airportDeparture(a3)
                    .airportDepartureCode(a4)
                    .aircrafts(aircraft)
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            FR.findFlightByFlightNumber(session, "75463");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllFlightsByAircraftId()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            FlightsRepository FR = new FlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            Airports a1 = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Pradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();

            Airports a2 = Airports.builder()
                    .name("Lozavo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Mascow")
                    .build();

            Airports a3 = Airports.builder()
                    .name("Pozovo")
                    .city(new City("Grads"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusia/Moscow")
                    .build();

            Airports a4 = Airports.builder()
                    .name("Ltzovo")
                    .city(new City("Graesk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusqia/Moscow")
                    .build();

            Flights f1 = Flights.builder()
                    .flightNumber("75463")
                    .scheduledArrival(new Timestamp(new Date().getTime()))
                    .scheduledDeparture(new Timestamp(new Date().getTime()))
                    .actualArrival(new Timestamp(new Date().getTime()))
                    .actualDeparture(new Timestamp(new Date().getTime()))
                    .status("true")
                    .airportArrival(a1)
                    .airportArrivalCode(a2)
                    .airportDeparture(a3)
                    .airportDepartureCode(a4)
                    .aircrafts(aircraft)
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            FR.findAllFlightsByAircraftId(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllFlightsByAircraftIdWithFlightNumber()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            FlightsRepository FR = new FlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            Airports a1 = Airports.builder()
                    .name("Lozovo")
                    .city(new City("Pradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Moscow")
                    .build();

            Airports a2 = Airports.builder()
                    .name("Lozavo")
                    .city(new City("Gradsk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Russia/Mascow")
                    .build();

            Airports a3 = Airports.builder()
                    .name("Pozovo")
                    .city(new City("Grads"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusia/Moscow")
                    .build();

            Airports a4 = Airports.builder()
                    .name("Ltzovo")
                    .city(new City("Graesk"))
                    .latitude(53456)
                    .longitude(76321)
                    .timezone("Rusqia/Moscow")
                    .build();

            Flights f1 = Flights.builder()
                    .flightNumber("75463")
                    .scheduledArrival(new Timestamp(new Date().getTime()))
                    .scheduledDeparture(new Timestamp(new Date().getTime()))
                    .actualArrival(new Timestamp(new Date().getTime()))
                    .actualDeparture(new Timestamp(new Date().getTime()))
                    .status("true")
                    .airportArrival(a1)
                    .airportArrivalCode(a2)
                    .airportDeparture(a3)
                    .airportDepartureCode(a4)
                    .aircrafts(aircraft)
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            FR.findAllFlightsByAircraftIdWithFlightNumber(session, 1L, "75463");
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
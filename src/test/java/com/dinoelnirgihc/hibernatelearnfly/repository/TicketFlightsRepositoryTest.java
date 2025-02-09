package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.ContactData;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.TicketFlightsId;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.User;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import com.dinoelnirgihc.hibernatelearnfly.entity.*;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TicketFlightsRepositoryTest {

    @Test
    public void crudTicketFlights()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

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

            TicketFlights TF1 = TicketFlights
                    .builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .flight(f1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10543))
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(TF1);
            TicketFlights TF1U = session.get(TicketFlights.class, new TicketFlightsId(1L, 1L));
            TF1U.setAmount(new BigDecimal(1032453));
            session.merge(TF1U);
            session.delete(TF1U);
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
    void findAllTicketFlights()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketFlightsRepository tFR = new TicketFlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

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

            TicketFlights TF1 = TicketFlights
                    .builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .flight(f1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10543))
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(TF1);

            tFR.findAllTicketFlights(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketFlightsByAmount()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketFlightsRepository tFR = new TicketFlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

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

            TicketFlights TF1 = TicketFlights
                    .builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .flight(f1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10543))
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(TF1);

            tFR.findAllTicketFlightsByAmount(session, new BigDecimal(10543));
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketFlightsByFlightId()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketFlightsRepository tFR = new TicketFlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

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

            TicketFlights TF1 = TicketFlights
                    .builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .flight(f1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10543))
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(TF1);

            tFR.findAllTicketFlightsByFlightId(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketFlightsCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketFlightsRepository tFR = new TicketFlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

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

            TicketFlights TF1 = TicketFlights
                    .builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .flight(f1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10543))
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(TF1);

            tFR.findAllTicketFlightsCriteria(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketFlightsByAmountCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketFlightsRepository tFR = new TicketFlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

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

            TicketFlights TF1 = TicketFlights
                    .builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .flight(f1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10543))
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(TF1);

            tFR.findAllTicketFlightsByAmountCriteria(session, new BigDecimal(10543));
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketFlightsByFlightIdCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketFlightsRepository tFR = new TicketFlightsRepository();
            Aircrafts aircraft = Aircrafts.builder().model("Airbus").range(7500).build();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

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

            TicketFlights TF1 = TicketFlights
                    .builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .flight(f1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10543))
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(TF1);

            tFR.findAllTicketFlightsByFlightIdCriteria(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
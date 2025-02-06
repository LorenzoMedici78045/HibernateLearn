package com.dinoelnirgihc.hibernatelearnfly;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.*;
import com.dinoelnirgihc.hibernatelearnfly.entity.*;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


public class CRUDTest
{


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
    public void crudBoardingPasses()
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

            TicketFlights tF = TicketFlights.builder()
                    .ticketFlightsId(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10167))
                    .flight(f1)
                    .build();

            session.persist(aircraft);
            session.persist(a1);
            session.persist(a2);
            session.persist(a3);
            session.persist(a4);
            session.persist(f1);
            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            session.persist(tF);

            BoardingPasses bP = BoardingPasses.builder().
                    id(new BoardingPassesId(1L, 1L))
                    .boardingNumber(1L)
                    .seatNumber(1L)
                    .ticket(tF)
                    .build();
            session.persist(bP);
            BoardingPasses bP1 = session.get(BoardingPasses.class, new BoardingPassesId(1L, 1L));
            bP1.setSeatNumber(245763L);
            session.merge(bP1);
            session.delete(bP1);
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
    public void crudBookings()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            session.persist(b1);
            Bookings bok1 = session.get(Bookings.class, 1L);
            bok1.setTotalAmount(new BigDecimal(11267));
            session.merge(bok1);
            session.delete(bok1);
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
                    .ticketFlightsId(new TicketFlightsId(1L, 1L))
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
    public void crudTickets()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

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

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            Tickets tic1 = session.get(Tickets.class, 1L);
            tic1.setUser(new User("B", "12436", ContactData.builder()
                    .email("susqe@mail.ru")
                    .phone("+79285736450").build()));
            session.merge(tic1);
            session.delete(tic1);
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

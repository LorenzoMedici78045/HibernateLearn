package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import com.dinoelnirgihc.hibernatelearnfly.converterClasses.ContactData;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.*;
import com.dinoelnirgihc.hibernatelearnfly.entity.*;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

class BoardingPassesRepositoryTest {

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
                    .id(new TicketFlightsId(1L, 1L))
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
    void findAllBoardingPassesCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findAllBoardingPassesCriteria(session);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoarPassByBoardNumberCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findBoarPassByBoardNumberCriteria(session, 1L);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoarPassBySeatNumberCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findBoarPassBySeatNumberCriteria(session, 1L);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoardingPassesByTicketIdCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .ticketFlights(new ArrayList<TicketFlights>())
                    .build();

            BoardingPasses bP = BoardingPasses.builder().
                    id(new BoardingPassesId(1L, 1L))
                    .boardingNumber(1L)
                    .seatNumber(1L)
                    .build();

            TicketFlights tF = TicketFlights.builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10167))
                    .boardingPasses(new ArrayList<BoardingPasses>())
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
            session.persist(bP);

            t1.addTicketFlights(tF);
            tF.addBoarPass(bP);
            session.merge(f1);
            session.merge(tF);

            BPR.findBoardingPassesByTicketIdCriteria(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllBoardingPasses()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findAllBoardingPasses(session);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoarPassByBoardNumber()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findBoarPassByBoardNumber(session, 1L);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoarPassBySeatNumber()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findBoarPassBySeatNumber(session, 1L);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoardingPassesByTicketId()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .ticketFlights(new ArrayList<TicketFlights>())
                    .build();

            BoardingPasses bP = BoardingPasses.builder().
                    id(new BoardingPassesId(1L, 1L))
                    .boardingNumber(1L)
                    .seatNumber(1L)
                    .build();

            TicketFlights tF = TicketFlights.builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10167))
                    .boardingPasses(new ArrayList<BoardingPasses>())
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
            session.persist(bP);

            t1.addTicketFlights(tF);
            tF.addBoarPass(bP);
            session.merge(f1);
            session.merge(tF);

            BPR.findBoardingPassesByTicketId(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllBoardingPassesQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findAllBoardingPassesQueryDsl(session);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoarPassByBoardNumberQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findBoarPassByBoardNumberQueryDsl(session, 1L);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoarPassBySeatNumberQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .id(new TicketFlightsId(1L, 1L))
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
            BPR.findBoarPassBySeatNumberQueryDsl(session, 1L);

        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBoardingPassesByTicketIdQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            BoardingPassesRepository BPR = new BoardingPassesRepository();
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
                    .ticketFlights(new ArrayList<TicketFlights>())
                    .build();

            BoardingPasses bP = BoardingPasses.builder().
                    id(new BoardingPassesId(1L, 1L))
                    .boardingNumber(1L)
                    .seatNumber(1L)
                    .build();

            TicketFlights tF = TicketFlights.builder()
                    .id(new TicketFlightsId(1L, 1L))
                    .ticket(t1)
                    .fareConditions(fareConditionsType.BUSINESS)
                    .amount(new BigDecimal(10167))
                    .boardingPasses(new ArrayList<BoardingPasses>())
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
            session.persist(bP);

            t1.addTicketFlights(tF);
            tF.addBoarPass(bP);
            session.merge(f1);
            session.merge(tF);

            BPR.findBoardingPassesByTicketIdQueryDsl(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
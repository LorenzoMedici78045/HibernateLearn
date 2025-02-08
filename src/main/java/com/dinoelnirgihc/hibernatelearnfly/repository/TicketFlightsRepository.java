package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.TicketFlights;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TicketFlightsRepository
{
    public List<TicketFlights> findAllTicketFlights(Session session)
    {
        session.beginTransaction();
        List<TicketFlights> list = session.createQuery("from TicketFlights", TicketFlights.class).list();
        session.getTransaction().commit();
        return list;
    }

    public List<TicketFlights> findAllTicketFlightsByAmount(Session session, BigDecimal amount)
    {
        session.beginTransaction();
        List<TicketFlights> list = session.createQuery("select t from TicketFlights t" +
                        " where t.amount = :amount", TicketFlights.class)
                .setParameter("amount", amount).getResultList();
        session.getTransaction().commit();
        return list;
    }

    public List<TicketFlights> findAllTicketFlightsByFlightId(Session session, Long flightId)
    {
        session.beginTransaction();
        List<TicketFlights> list = session.createQuery("select tF from Flights f" +
                        " join f.ticketsFlight tF" +
                        " where f.id = :flightId", TicketFlights.class)
                .setParameter("flightId", flightId).getResultList();
        session.getTransaction().commit();
        return list;
    }
}

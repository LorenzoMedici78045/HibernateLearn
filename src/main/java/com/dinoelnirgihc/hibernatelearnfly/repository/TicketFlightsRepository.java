package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    public List<TicketFlights> findAllTicketFlightsCriteria(Session session)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TicketFlights> cq = cb.createQuery(TicketFlights.class);
        Root<TicketFlights> root = cq.from(TicketFlights.class);

        cq.select(root);
        return session.createQuery(cq).list();
    }

    public List<TicketFlights> findAllTicketFlightsByAmountCriteria(Session session, BigDecimal amount)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TicketFlights> cq = cb.createQuery(TicketFlights.class);
        Root<TicketFlights> root = cq.from(TicketFlights.class);

        cq.select(root).where(cb.equal(root.get("amount"), amount));
        return session.createQuery(cq).list();
    }

    public List<TicketFlights> findAllTicketFlightsByFlightIdCriteria(Session session, Long flightId)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(TicketFlights.class);
        Root root = cq.from(Flights.class);
        var tikFly = root.join("ticketsFlight");

        cq.select(tikFly).where(cb.equal(root.get("id"), flightId));
        return session.createQuery(cq).list();
    }

    public List<TicketFlights> findAllTicketFlightsQueryDsl(Session session)
    {
        return new JPAQuery<TicketFlights>(session)
                .select(QTicketFlights.ticketFlights)
                .from(QTicketFlights.ticketFlights)
                .where()
                .fetch();
    }

    public List<TicketFlights> findAllTicketFlightsByAmountQueryDsl(Session session, BigDecimal amount)
    {
        return new JPAQuery<TicketFlights>(session)
                .select(QTicketFlights.ticketFlights)
                .from(QTicketFlights.ticketFlights)
                .where(QTicketFlights.ticketFlights.amount.eq(amount))
                .fetch();
    }

    public List<TicketFlights> findAllTicketFlightsByFlightIdQueryDsl(Session session, Long flightId)
    {
        return new JPAQuery<TicketFlights>(session)
                .select(QTicketFlights.ticketFlights)
                .from(QTicketFlights.ticketFlights)
                .join(QTicketFlights.ticketFlights.flight, QFlights.flights)
                .where(QFlights.flights.id.eq(flightId))
                .fetch();
    }
}

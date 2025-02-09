package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Bookings;
import com.dinoelnirgihc.hibernatelearnfly.entity.Flights;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class FlightsRepository
{
    public List<Flights> findAllFlights(Session session)
    {
        session.beginTransaction();
        List<Flights> flights = session.createQuery("from Flights", Flights.class).list();
        session.getTransaction().commit();
        return flights;
    }

    public Flights findFlightByFlightNumber(Session session, String flightNumber)
    {
        session.beginTransaction();
        Flights flight = session.createQuery("select f from Flights f" +
                        " where f.flightNumber = :flightNumber", Flights.class)
                .setParameter("flightNumber", flightNumber).uniqueResult();
        session.getTransaction().commit();
        return flight;
    }

    public List<Flights> findAllFlightsByAircraftId(Session session, Long aircraftId)
    {
        session.beginTransaction();
        List<Flights> aircraftFlights = session.createQuery("select f from Aircrafts a" +
                " join a.flights f where a.id = :aircraftId", Flights.class)
                .setParameter("aircraftId", aircraftId)
                .list();
        session.getTransaction().commit();
        return aircraftFlights;
    }

    public List<Flights> findAllFlightsByAircraftIdWithFlightNumber(Session session, Long aircraftId ,String flightNumber)
    {
        session.beginTransaction();
        List<Flights> aircraftFlights = session.createQuery("select f from Aircrafts a" +
                " join a.flights f where a.id = :aircraftId and f.flightNumber = :flightNumber", Flights.class)
                .setParameter("flightNumber", flightNumber)
                .setParameter("aircraftId", aircraftId)
                .list();
        session.getTransaction().commit();
        return aircraftFlights;
    }

    public List<Flights> findAllFlightsCriteria(Session session)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Flights> cq = cb.createQuery(Flights.class);
        Root<Flights> root = cq.from(Flights.class);

        cq.select(root);
        return session.createQuery(cq).list();
    }

    public Flights findFlightByFlightNumberCriteria(Session session, String flightNumber)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Flights> cq = cb.createQuery(Flights.class);
        Root<Flights> root = cq.from(Flights.class);

        cq.select(root).where(cb.equal(root.get("flightNumber"), flightNumber));
        return session.createQuery(cq).uniqueResult();
    }

    public List<Flights> findAllFlightsByAircraftIdCriteria(Session session, Long aircraftId)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Flights> cq = cb.createQuery(Flights.class);
        Root<Flights> root = cq.from(Flights.class);
        root.join("aircrafts");

        cq.select(root).where(cb.equal(root.get("id"), aircraftId));
        return session.createQuery(cq).list();
    }

    public List<Flights> findAllFlightsByAircraftIdWithFlightNumberCriteria(Session session, Long aircraftId ,String flightNumber)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Flights> cq = cb.createQuery(Flights.class);
        Root<Flights> root = cq.from(Flights.class);
        root.join("aircrafts");

        cq.select(root).where(cb.equal(root.get("id"), aircraftId)).where(cb.equal(root.get("flightNumber"), flightNumber));
        return session.createQuery(cq).list();
    }
}

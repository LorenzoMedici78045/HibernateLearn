package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.entity.Seats;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class SeatsRepository
{
    public List<Seats> findallSeats(Session session)
    {
        session.beginTransaction();
        List<Seats> list = session.createQuery("from Seats", Seats.class).list();
        session.getTransaction().commit();
        return list;
    }

    public List<Seats> findAllSeatByFareCond(Session session, fareConditionsType fareCond)
    {
        session.beginTransaction();
        List<Seats> list = session.createQuery("select s from Seats s" +
                        " where s.fareConditions = :fareCond", Seats.class)
                .setParameter("fareCond", fareCond).list();
        return list;
    }

    public List<Seats> findAllSeatByAircraftId(Session session, Long aircraftId)
    {
        session.beginTransaction();
        List<Seats> list = session.createQuery("select s from Aircrafts a" +
                " join a.seats s where a.id = :aircraftId", Seats.class)
                .setParameter("aircraftId", aircraftId).list();
        return list;
    }

    public List<Seats> findallSeatsCriteria(Session session)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Seats> cq = cb.createQuery(Seats.class);
        Root<Seats> root = cq.from(Seats.class);

        cq.select(root);
        return session.createQuery(cq).list();
    }

    public List<Seats> findAllSeatByFareCondCriteria(Session session, fareConditionsType fareCond)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Seats> cq = cb.createQuery(Seats.class);
        Root<Seats> root = cq.from(Seats.class);

        cq.select(root).where(cb.equal(root.get("fareConditions"), fareCond));
        return session.createQuery(cq).list();
    }

    public List<Seats> findAllSeatByAircraftIdCriteria(Session session, Long aircraftId)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Seats.class);
        Root root = cq.from(Aircrafts.class);
        var seats =  root.join("seats");

        cq.select(seats).where(cb.equal(root.get("id"), aircraftId));
        return session.createQuery(cq).list();
    }
}

package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import com.dinoelnirgihc.hibernatelearnfly.entity.Seats;
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
}

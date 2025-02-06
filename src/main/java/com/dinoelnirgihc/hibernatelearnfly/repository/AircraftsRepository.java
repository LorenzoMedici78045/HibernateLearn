package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AircraftsRepository
{

    public List<Aircrafts> findAllAircrafts(Session session)
    {
        session.beginTransaction();
        List<Aircrafts> list = session.createQuery("from Aircrafts").list();
        session.getTransaction().commit();
        return list;
    }

    public String returnModelById(Session session,Long id)
    {
        session.beginTransaction();
        Aircrafts aircrafts = session.get(Aircrafts.class, id);
        session.getTransaction().commit();
        return aircrafts.getModel();
    }

    public Integer returnRangeById(Session session,Long id)
    {
        session.beginTransaction();
        Aircrafts aircrafts = session.get(Aircrafts.class, id);
        session.getTransaction().commit();
        return aircrafts.getRange();
    }

    public List<Aircrafts> returnAircraftsByRangeMore(Session session,Long MoreRange)
    {
        session.beginTransaction();
        List<Aircrafts> aircraftsRangeMore =
                session.createQuery("Select a from Aircrafts a where a.range > :MoreRange", Aircrafts.class)
                        .setParameter("MoreRange", MoreRange).getResultList();
        return aircraftsRangeMore;
    }

    public List<Aircrafts> returnAircraftsBYModelName(Session session,String ModelName)
    {
        session.beginTransaction();
        List<Aircrafts> aircraftsbyModel =
                session.createQuery("Select a from Aircrafts a where a.model = :ModelName", Aircrafts.class)
                        .setParameter("ModelName", ModelName).getResultList();
        return aircraftsbyModel;
    }
}

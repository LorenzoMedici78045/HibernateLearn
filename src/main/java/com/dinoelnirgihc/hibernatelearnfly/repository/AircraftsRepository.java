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
        List<Aircrafts> list = session.createQuery("from Aircrafts", Aircrafts.class).list();
        session.getTransaction().commit();
        return list;
    }

    public String selectModelById(Session session,Long id)
    {
        session.beginTransaction();
        Aircrafts aircrafts = session.get(Aircrafts.class, id);
        session.getTransaction().commit();
        return aircrafts.getModel();
    }

    public Integer selectRangeById(Session session,Long id)
    {
        session.beginTransaction();
        Aircrafts aircrafts = session.get(Aircrafts.class, id);
        session.getTransaction().commit();
        return aircrafts.getRange();
    }

    public List<Aircrafts> selectAircraftsByRangeMore(Session session,int MoreRange)
    {
        session.beginTransaction();
        List<Aircrafts> aircraftsRangeMore =
                session.createQuery("Select a from Aircrafts a where a.range > :MoreRange", Aircrafts.class)
                        .setParameter("MoreRange", MoreRange).getResultList();
        return aircraftsRangeMore;
    }

    public List<Aircrafts> selectAircraftsBYModelName(Session session,String ModelName)
    {
        session.beginTransaction();
        List<Aircrafts> aircraftsbyModel =
                session.createQuery("Select a from Aircrafts a where a.model = :ModelName", Aircrafts.class)
                        .setParameter("ModelName", ModelName).getResultList();
        return aircraftsbyModel;
    }
}

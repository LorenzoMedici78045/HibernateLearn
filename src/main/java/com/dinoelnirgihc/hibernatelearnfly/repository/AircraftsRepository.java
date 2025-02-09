package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    public List<Aircrafts> findAllAircraftsCriteria(Session session)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Aircrafts> cQ =  cB.createQuery(Aircrafts.class);
        Root root = cQ.from(Aircrafts.class);
        cQ.select(root);
        return session.createQuery(cQ).getResultList();
    }

    public String selectModelByIdCriteria(Session session,Long id)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<String> cQ = cB.createQuery(String.class);
        Root root = cQ.from(Aircrafts.class);

        cQ.select(root.get("model")).where(cB.equal(root.get("id"), id));
        return session.createQuery(cQ).uniqueResult();
    }

    public Integer selectRangeByIdCriteria(Session session,Long id)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Integer> cQ = cB.createQuery(Integer.class);
        Root root = cQ.from(Aircrafts.class);

        cQ.select(root.get("range")).where(cB.equal(root.get("id"), id));
        return session.createQuery(cQ).uniqueResult();
    }

    public List<Aircrafts> selectAircraftsByRangeMoreCriteria(Session session,int MoreRange)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Aircrafts> cQ = cB.createQuery(Aircrafts.class);
        Root root = cQ.from(Aircrafts.class);

        cQ.select(root).where(cB.greaterThan(root.get("range"), MoreRange));

        return session.createQuery(cQ).list();
    }

    public List<Aircrafts> selectAircraftsBYModelNameCriteria(Session session,String ModelName)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Aircrafts> cQ = cB.createQuery(Aircrafts.class);
        Root root = cQ.from(Aircrafts.class);

        cQ.select(root).where(cB.equal(root.get("model"), ModelName));

        return session.createQuery(cQ).list();
    }

    /*public List<Aircrafts> findAllAircraftsQueryDsl(Session session)
    {

        return JPAQuery<Aircrafts>();
    }*/
}

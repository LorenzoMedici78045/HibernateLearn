package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.entity.Airports;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class AirportsRepository
{
    public List<Airports> selectAllAirports(Session session)
    {
        session.beginTransaction();
        List<Airports> list = session.createQuery("from Airports", Airports.class).list();
        session.getTransaction().commit();
        return list;
    }

    public Airports returnAirportByName(Session session, String name)
    {
        session.beginTransaction();
        Airports airport = session.createQuery("Select a from Airports a where a.name = :name", Airports.class)
                .setParameter("name", name).uniqueResult();
        session.getTransaction().commit();
        return airport;
    }

    public List<Airports> selectAllAirportsByTimezone(Session session, String Timezone)
    {
        session.beginTransaction();
        List<Airports> airports = session.createQuery("Select a from Airports a where a.timezone = :Timezone", Airports.class)
                .setParameter("Timezone", Timezone).getResultList();
        session.getTransaction().commit();
        return airports;
    }

    public List<Airports> selectAllAirportsByTimezoneMax(Session session, String Timezone, int max)
    {
        session.beginTransaction();
        List<Airports> airports = session.createQuery("Select a from Airports a where a.timezone = :Timezone", Airports.class)
                .setParameter("Timezone", Timezone).setMaxResults(max).getResultList();
        session.getTransaction().commit();
        return airports;
    }

    public List<Airports> selectAllAirportsByCity(Session session, City City)
    {
        session.beginTransaction();
        List<Airports> airports = session.createQuery("Select a from Airports a where a.city = :City", Airports.class)
                .setParameter("City", City).getResultList();
        session.getTransaction().commit();
        return airports;
    }

    public List<Airports> selectAllAirportsCriteria(Session session)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Airports> cQ = cB.createQuery(Airports.class);
        Root<Airports> root = cQ.from(Airports.class);
        cQ.select(root);
        return session.createQuery(cQ).list();
    }

    public Airports returnAirportByNameCriteria(Session session, String name)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Airports> cQ = cB.createQuery(Airports.class);
        Root root = cQ.from(Airports.class);

        cQ.select(root).where(cB.equal(root.get("name"), name));
        return session.createQuery(cQ).uniqueResult();
    }

    public List<Airports> selectAllAirportsByTimezoneCriteria(Session session, String Timezone)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Airports> cQ = cB.createQuery(Airports.class);
        Root<Airports> root = cQ.from(Airports.class);

        cQ.select(root).where(cB.equal(root.get("timezone"), Timezone));

        return session.createQuery(cQ).list();
    }

    public List<Airports> selectAllAirportsByTimezoneMaxCriteria(Session session, String Timezone, int max)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Airports> cQ = cB.createQuery(Airports.class);
        Root<Airports> root = cQ.from(Airports.class);

        cQ.select(root).where(cB.equal(root.get("timezone"), Timezone));

        return session.createQuery(cQ).setMaxResults(max).list();
    }

    public List<Airports> selectAllAirportsByCityCriteria(Session session, City City)
    {
        CriteriaBuilder cB = session.getCriteriaBuilder();
        CriteriaQuery<Airports> cQ = cB.createQuery(Airports.class);
        Root<Airports> root = cQ.from(Airports.class);

        cQ.select(root).where(cB.equal(root.get("city"), City));

        return session.createQuery(cQ).list();
    }
}

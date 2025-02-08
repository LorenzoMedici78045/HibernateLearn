package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.City;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.entity.Airports;
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

}

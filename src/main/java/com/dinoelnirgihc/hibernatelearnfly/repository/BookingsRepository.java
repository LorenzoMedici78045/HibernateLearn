package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Bookings;
import com.dinoelnirgihc.hibernatelearnfly.entity.Tickets;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class BookingsRepository
{
    public List<Bookings> findAllBookings(Session session)
    {
        session.beginTransaction();
        List<Bookings> bookings = session.createQuery("from Bookings", Bookings.class).list();
        session.getTransaction().commit();
        return bookings;
    }

    public List<Bookings> findBookingsByTotalAmountMore(Session session, BigDecimal totalAmount)
    {
        session.beginTransaction();
        List<Bookings> list = session.createQuery("select b from Bookings b" +
                        " where b.totalAmount > :totalAmount", Bookings.class)
                .setParameter("totalAmount", totalAmount).list();
        session.getTransaction().commit();
        return list;
    }

    public List<Bookings> findBookingsByTotalAmountMore(Session session, BigDecimal totalAmount, int max)
    {
        session.beginTransaction();
        List<Bookings> list = session.createQuery("select b from Bookings b" +
                        " where b.totalAmount > :totalAmount", Bookings.class)
                .setParameter("totalAmount", totalAmount).setMaxResults(max).list();
        session.getTransaction().commit();
        return list;
    }

    public List<Bookings> findBookingsByTotalAmountLess(Session session, BigDecimal totalAmount)
    {
        session.beginTransaction();
        List<Bookings> list = session.createQuery("select b from Bookings b" +
                        " where b.totalAmount < :totalAmount", Bookings.class)
                .setParameter("totalAmount", totalAmount).list();
        session.getTransaction().commit();
        return list;
    }

    public List<Bookings> findBookingsByBookDate(Session session, Timestamp bookDate)
    {
        session.beginTransaction();
        List<Bookings> list = session.createQuery("select b from Bookings b" +
                        " where b.bookDate = :bookDate", Bookings.class)
                .setParameter("bookDate", bookDate).list();
        session.getTransaction().commit();
        return list;
    }

}

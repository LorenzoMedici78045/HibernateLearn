package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Bookings;
import com.dinoelnirgihc.hibernatelearnfly.entity.Tickets;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import javax.swing.*;
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

    public List<Bookings> findAllBookingsCriteria(Session session)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Bookings> cq = cb.createQuery(Bookings.class);
        Root<Bookings> root = cq.from(Bookings.class);
        cq.select(root);

        return session.createQuery(cq).list();
    }

    public List<Bookings> findBookingsByTotalAmountMoreCriteria(Session session, BigDecimal totalAmount)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Bookings> cq = cb.createQuery(Bookings.class);
        Root<Bookings> root = cq.from(Bookings.class);

        cq.select(root).where(cb.greaterThan(root.get("totalAmount"), totalAmount));
        return session.createQuery(cq).list();
    }

    public List<Bookings> findBookingsByTotalAmountMoreCriteria(Session session, BigDecimal totalAmount, int max)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Bookings> cq = cb.createQuery(Bookings.class);
        Root<Bookings> root = cq.from(Bookings.class);

        cq.select(root).where(cb.greaterThan(root.get("totalAmount"), totalAmount));
        return session.createQuery(cq).setMaxResults(max).list();
    }

    public List<Bookings> findBookingsByTotalAmountLessCriteria(Session session, BigDecimal totalAmount)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Bookings> cq = cb.createQuery(Bookings.class);
        Root<Bookings> root = cq.from(Bookings.class);

        cq.select(root).where(cb.lessThan(root.get("totalAmount"), totalAmount));
        return session.createQuery(cq).list();
    }

    public List<Bookings> findBookingsByBookDateCriteria(Session session, Timestamp bookDate)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Bookings> cq = cb.createQuery(Bookings.class);
        Root<Bookings> root = cq.from(Bookings.class);

        cq.select(root).where(cb.equal(root.get("bookDate"), bookDate));
        return session.createQuery(cq).list();
    }
}

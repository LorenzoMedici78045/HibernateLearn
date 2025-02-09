package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.User;
import com.dinoelnirgihc.hibernatelearnfly.entity.QBookings;
import com.dinoelnirgihc.hibernatelearnfly.entity.QTickets;
import com.dinoelnirgihc.hibernatelearnfly.entity.Tickets;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;
/**
 * Репозиторий сущности Билет, хранящий методы взаимодействия с БД
 * */
public class TicketsRepository
{
    /**
     * Метод возвращает все билеты
     * @return ArrayList всех билетов
     * */
    public List<Tickets> findAllTickets(Session session)
    {
        session.beginTransaction();
        List<Tickets> tickets = session.createQuery("from Tickets", Tickets.class).list();
        session.getTransaction().commit();
        return tickets;
    }
    /**
     * Метод возвращает все билетов, которые соответсвуют определенной сессии бронирования
     * @return ArrayList всех билетов
     * */
    public List<Tickets> findAllTicketsByBookingsId(Session session, Long bookingsId)
    {
        session.beginTransaction();
        List<Tickets> list = session.createQuery("select t from Bookings b" +
                        " join b.ticketsList t" +
                        " where b.id = :bookingsId", Tickets.class)
                .setParameter("bookingsId", bookingsId)
                .list();
        session.getTransaction().commit();
        return list;
    }
    /**
     * Метод возвращает билет, которые соответсвуют определенным данным паспорта
     * @return Ticket
     * */
    public Tickets findTicketByUserPassword(Session session, String userPassword)
    {
        session.beginTransaction();
        User u = session.createQuery("select u from Tickets t join t.user u where u.password = :userPassword", User.class)
                .setParameter("userPassword", userPassword).uniqueResult();
        Tickets t = session.createQuery("select t from Tickets t" +
                " where t.user = :u", Tickets.class)
                .setParameter("u", u).uniqueResult();
        return t;
    }

    public List<Tickets> findAllTicketsCriteria(Session session)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tickets> cq = cb.createQuery(Tickets.class);
        Root<Tickets> root = cq.from(Tickets.class);

        cq.select(root);
        return session.createQuery(cq).list();
    }

    public List<Tickets> findAllTicketsByBookingsIdCriteria(Session session, Long bookingsId)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tickets> cq = cb.createQuery(Tickets.class);
        Root<Tickets> root = cq.from(Tickets.class);
        root.join("bookings");

        cq.select(root).where(cb.equal(root.get("id"), bookingsId));
        return session.createQuery(cq).list();
    }

    public Tickets findTicketByUserPasswordCriteria(Session session, String userPassword)
    {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Tickets.class);
        Root root = cq.from(Tickets.class);
        var user = root.join("user");

        cq.select(root).where(cb.equal(user.get("password"), userPassword));
        return (Tickets) session.createQuery(cq).uniqueResult();
    }

    public List<Tickets> findAllTicketsQueryDsl(Session session)
    {
        return new JPAQuery<Tickets>(session)
                .select(QTickets.tickets)
                .from(QTickets.tickets)
                .where()
                .fetch();
    }

    public List<Tickets> findAllTicketsByBookingsIdQueryDsl(Session session, Long bookingsId)
    {
        return new JPAQuery<Tickets>(session)
                .select(QTickets.tickets)
                .from(QTickets.tickets)
                .join(QTickets.tickets.bookings, QBookings.bookings)
                .where(QBookings.bookings.id.eq(bookingsId))
                .fetch();
    }

    public Tickets findTicketByUserPasswordQureyDsl(Session session, String userPassword)
    {
        return new JPAQuery<Tickets>(session)
                .select(QTickets.tickets)
                .from(QTickets.tickets)
                .where(QTickets.tickets.user.password.eq(userPassword))
                .fetchFirst();
    }
}

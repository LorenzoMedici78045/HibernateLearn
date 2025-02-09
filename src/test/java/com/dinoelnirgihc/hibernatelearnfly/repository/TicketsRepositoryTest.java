package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.converterClasses.ContactData;
import com.dinoelnirgihc.hibernatelearnfly.embeddable.User;
import com.dinoelnirgihc.hibernatelearnfly.entity.Bookings;
import com.dinoelnirgihc.hibernatelearnfly.entity.Tickets;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

class TicketsRepositoryTest {

    @Test
    public void crudTickets()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            Tickets tic1 = session.get(Tickets.class, 1L);
            tic1.setUser(new User("B", "12436", ContactData.builder()
                    .email("susqe@mail.ru")
                    .phone("+79285736450").build()));
            session.merge(tic1);
            session.delete(tic1);
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTickets()
    {
            try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
            {
                Session session = sessionFactory.openSession();

                TicketsRepository tR = new TicketsRepository();
                User u1 = new User("A", "123", ContactData.builder()
                        .email("sus@mail.ru")
                        .phone("+79185736450").build());

                Bookings b1 = Bookings.builder()
                        .totalAmount(new BigDecimal(100567))
                        .bookDate(new Timestamp(new Date().getTime()))
                        .build();

                Bookings b2 = Bookings.builder()
                        .totalAmount(new BigDecimal(100567))
                        .bookDate(new Timestamp(new Date().getTime()))
                        .build();

                Tickets t1 = Tickets.builder()
                        .user(u1)
                        .bookings(b1)
                        .bookingsBook(b2)
                        .build();

                session.persist(b1);
                session.persist(b2);
                session.persist(t1);
                tR.findAllTickets(session);
            }
            catch(Exception e)
            {
                System.err.println("Initial SessionFactory creation failed." + e);
                throw new ExceptionInInitializerError(e);
            }
    }

    @Test
    void findAllTicketsByBookingsId()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findAllTicketsByBookingsId(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findTicketByUserPassword()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findTicketByUserPassword(session, u1.getPassword());
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketsCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findAllTicketsCriteria(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketsByBookingsIdCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findAllTicketsByBookingsIdCriteria(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findTicketByUserPasswordCriteria()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findTicketByUserPasswordCriteria(session, u1.getPassword());
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketsQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findAllTicketsQueryDsl(session);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllTicketsByBookingsIdQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findAllTicketsByBookingsIdQueryDsl(session, 1L);
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findTicketByUserPasswordQueryDsl()
    {
        try(SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();

            TicketsRepository tR = new TicketsRepository();
            User u1 = new User("A", "123", ContactData.builder()
                    .email("sus@mail.ru")
                    .phone("+79185736450").build());

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Bookings b2 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            Tickets t1 = Tickets.builder()
                    .user(u1)
                    .bookings(b1)
                    .bookingsBook(b2)
                    .build();

            session.persist(b1);
            session.persist(b2);
            session.persist(t1);
            tR.findTicketByUserPasswordQureyDsl(session, u1.getPassword());
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Bookings;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookingsRepositoryTest {

    @Test
    public void crudBookings() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();

            session.persist(b1);
            Bookings bok1 = session.get(Bookings.class, 1L);
            bok1.setTotalAmount(new BigDecimal(11267));
            session.merge(bok1);
            session.delete(bok1);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllBookings() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);
            BP.findAllBookings(session);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountMore() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountMore(session, new BigDecimal(100567));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void FindBookingsByTotalAmountMore() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountMore(session, new BigDecimal(100567), 5);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountLess() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountLess(session, new BigDecimal(100567));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByBookDate() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByBookDate(session, new Timestamp(new Date().getTime()));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findAllBookingsCriteria() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);
            BP.findAllBookingsCriteria(session);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountMoreCriteria() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountMoreCriteria(session, new BigDecimal(100567));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountMoreCriteriaMax() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountMoreCriteria(session, new BigDecimal(100567), 5);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountLessCriteria() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountLessCriteria(session, new BigDecimal(100567));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByBookDateCriteria() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByBookDateCriteria(session, new Timestamp(new Date().getTime()));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }

    }

    @Test
    void findAllBookingsQueryDsl() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);
            BP.findAllBookingsQueryDsl(session);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountMoreQueryDsl() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountMoreQueryDsl(session, new BigDecimal(100567));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountMoreMaxQueryDsl() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountMoreQueryDsl(session, new BigDecimal(100567), 5);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByTotalAmountLessQueryDsl() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByTotalAmountLessQueryDsl(session, new BigDecimal(100567));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @Test
    void findBookingsByBookDateQueryDsl() {
        try (SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            BookingsRepository BP = new BookingsRepository();
            Bookings b1 = Bookings.builder()
                    .totalAmount(new BigDecimal(100567))
                    .bookDate(new Timestamp(new Date().getTime()))
                    .build();
            session.persist(b1);

            BP.findBookingsByBookDateQueryDsl(session, new Timestamp(new Date().getTime()));
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }

    }
}
package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import com.dinoelnirgihc.hibernatelearnfly.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;
/**
 * Репозиторий сущности ПосадочныеТалоны, хранящий методы взаимодействия с БД
 * */
public class BoardingPassesRepository {

    /**
     * Метод возвращает все талоны
     * @return ArrayList всех талонов
     * */
    public List<BoardingPasses> findAllBoardingPasses(Session session) {
        session.beginTransaction();
        List<BoardingPasses> list = session.createQuery("from BoardingPasses", BoardingPasses.class).list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * Метод возвращает талон по его номеру
     * @return BoardingPasses
     * */
    public BoardingPasses findBoarPassByBoardNumber(Session session, Long boardNumber) {
        session.beginTransaction();
        BoardingPasses boarPass = session
                .createQuery("select b from BoardingPasses b where b.boardingNumber = :boardNumber", BoardingPasses.class)
                .setParameter("boardNumber", boardNumber).uniqueResult();
        session.getTransaction().commit();
        return boarPass;
    }
    /**
     * Метод возвращает талон по номеру места
     * @return BoardingPasses
     * */
    public BoardingPasses findBoarPassBySeatNumber(Session session, Long seatNumber) {
        session.beginTransaction();
        BoardingPasses boarPass = session
                .createQuery("select b from BoardingPasses b where b.seatNumber = :seatNumber", BoardingPasses.class)
                .setParameter("seatNumber", seatNumber).uniqueResult();
        session.getTransaction().commit();
        return boarPass;
    }

    /**
     * Метод возвращает все талоны, принадлежащие билету, по его id
     * @return ArrayList всех талонов
     * */
    public List<BoardingPasses> findBoardingPassesByTicketId(Session session, Long TicketId) {
        session.beginTransaction();
        List<BoardingPasses> bP = session.createQuery("select bp from BoardingPasses bp" +
                        " join bp.ticket tf join tf.ticket t where t.id = :TicketId", BoardingPasses.class)
                .setParameter("TicketId", TicketId).list();
        session.getTransaction().commit();
        return bP;
    }

    public List<BoardingPasses> findAllBoardingPassesCriteria(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BoardingPasses> cq = cb.createQuery(BoardingPasses.class);
        Root<BoardingPasses> root = cq.from(BoardingPasses.class);

        cq.select(root);
        return session.createQuery(cq).list();
    }

    public BoardingPasses findBoarPassByBoardNumberCriteria(Session session, Long boardNumber) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BoardingPasses> cq = cb.createQuery(BoardingPasses.class);
        Root<BoardingPasses> root = cq.from(BoardingPasses.class);

        cq.select(root).where(cb.equal(root.get("boardingNumber"), boardNumber));
        return session.createQuery(cq).uniqueResult();
    }

    public BoardingPasses findBoarPassBySeatNumberCriteria(Session session, Long seatNumber) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BoardingPasses> cq = cb.createQuery(BoardingPasses.class);
        Root root = cq.from(BoardingPasses.class);

        cq.select(root).where(cb.equal(root.get("seatNumber"), seatNumber));
        return session.createQuery(cq).uniqueResult();
    }

    public List<BoardingPasses> findBoardingPassesByTicketIdCriteria(Session session, Long TicketId) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BoardingPasses.class);
        Root root = cq.from(Tickets.class);
        var ticFly = root.join("ticketFlights");
        var boarPas = ticFly.join("boardingPasses");


        cq.select(boarPas).where(cb.equal(root.get("id"), TicketId));

        return session.createQuery(cq).list();
    }

    public List<BoardingPasses> findAllBoardingPassesQueryDsl(Session session) {
        return new JPAQuery<BoardingPasses>(session)
                .select(QBoardingPasses.boardingPasses)
                .from(QBoardingPasses.boardingPasses)
                .where()
                .fetch();
    }

    public BoardingPasses findBoarPassByBoardNumberQueryDsl(Session session, Long boardNumber) {
        return new JPAQuery<BoardingPasses>(session)
                .select(QBoardingPasses.boardingPasses)
                .from(QBoardingPasses.boardingPasses)
                .where()
                .fetchFirst();
    }

    public BoardingPasses findBoarPassBySeatNumberQueryDsl(Session session, Long seatNumber) {
        return new JPAQuery<BoardingPasses>(session)
                .select(QBoardingPasses.boardingPasses)
                .from(QBoardingPasses.boardingPasses)
                .where(QBoardingPasses.boardingPasses.seatNumber.eq(seatNumber))
                .fetchFirst();
    }

    public List<BoardingPasses> findBoardingPassesByTicketIdQueryDsl(Session session, Long TicketId) {
        return new JPAQuery<BoardingPasses>(session)
                .select(QBoardingPasses.boardingPasses)
                .from(QTickets.tickets)
                .join(QTickets.tickets.ticketFlights)
                .join(QTicketFlights.ticketFlights.boardingPasses)
                .where(QTickets.tickets.id.eq(TicketId))
                .fetch();
    }
}
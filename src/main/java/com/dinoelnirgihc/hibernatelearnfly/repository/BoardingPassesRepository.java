package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.embeddable.fareConditionsType;
import com.dinoelnirgihc.hibernatelearnfly.entity.BoardingPasses;
import com.dinoelnirgihc.hibernatelearnfly.entity.TicketFlights;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class BoardingPassesRepository
{
    public List<BoardingPasses> findAllBoardingPasses(Session session)
    {
        session.beginTransaction();
        List<BoardingPasses> list = session.createQuery("from BoardingPasses", BoardingPasses.class).list();
        session.getTransaction().commit();
        return list;
    }

    public BoardingPasses findBoarPassByBoardNumber(Session session, Long boardNumber)
    {
        session.beginTransaction();
        BoardingPasses boarPass = session
                .createQuery("select b from BoardingPasses b where b.boardingNumber = :boardNumber", BoardingPasses.class)
                .setParameter("boardNumber", boardNumber).uniqueResult();
        session.getTransaction().commit();
        return boarPass;
    }

    public BoardingPasses findBoarPassBySeatNumber(Session session, Long seatNumber)
    {
        session.beginTransaction();
        BoardingPasses boarPass = session
                .createQuery("select b from BoardingPasses b where b.seatNumber = :seatNumber", BoardingPasses.class)
                .setParameter("seatNumber", seatNumber).uniqueResult();
        session.getTransaction().commit();
        return boarPass;
    }

    public List<BoardingPasses> findBoardingPassesByTicketId(Session session, Long TicketId)
    {
        session.beginTransaction();
        List<BoardingPasses> bP = session.createQuery("Select bP from Tickets t" +
                        " join fetch t.ticketFlights tf" +
                        " join fetch tF.boardingPasses bP where t.id = :TicketId", BoardingPasses.class)
                .setParameter("TicketId", TicketId).list();
        session.getTransaction().commit();
        return bP;
    }

    public List<BoardingPasses> findBoardingPassesByTicketId1(Session session, Long TicketId)
    {
        session.beginTransaction();
        List<BoardingPasses> bP = session.createQuery("select bp from BoardingPasses bp" +
                        " join bp.ticket tf join tf.ticket t where t.id = :TicketId", BoardingPasses.class)
                .setParameter("TicketId", TicketId).list();
        session.getTransaction().commit();
        return bP;
    }

}

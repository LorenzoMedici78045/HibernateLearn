package com.dinoelnirgihc.hibernatelearnfly.repository;

import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.entity.QAircrafts;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Репозиторий сущности Самолеты, хранящий методы взаимодействия с БД
 * */
public class AircraftsRepository
{

    /**
     * Метод возвращает все самолеты
     * @return ArrayList всех самолетов
     * */
    public List<Aircrafts> findAllAircrafts(Session session)
    {
        session.beginTransaction();
        List<Aircrafts> list = session.createQuery("from Aircrafts", Aircrafts.class)
                .setReadOnly(true)
                .setCacheable(true)
                .setCacheRegion("Query")
                .list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * Метод возвращает модель самолета по его id
     * @return String модель
     * */
    public String selectModelById(Session session,Long id)
    {
        session.beginTransaction();
        Aircrafts aircrafts = session.get(Aircrafts.class, id);
        session.getTransaction().commit();
        return aircrafts.getModel();
    }

    /**
     * Метод возвращает дальность полета самолета по его id
     * @return Integer дальность
     * */
    public Integer selectRangeById(Session session,Long id)
    {
        session.beginTransaction();
        Aircrafts aircrafts = session.get(Aircrafts.class, id);
        session.getTransaction().commit();
        return aircrafts.getRange();
    }

    /**
     * Метод возвращает все самолеты, чья дальность полета выше указанного значения
     * @return ArrayList всех самолетов
     * */
    public List<Aircrafts> selectAircraftsByRangeMore(Session session,int MoreRange)
    {
        session.beginTransaction();
        List<Aircrafts> aircraftsRangeMore =
                session.createQuery("Select a from Aircrafts a where a.range > :MoreRange", Aircrafts.class)
                        .setParameter("MoreRange", MoreRange).getResultList();
        return aircraftsRangeMore;
    }
    /**
     * Метод возвращает все самолеты данной модели
     * @return ArrayList всех самолетов
     * */
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

   public List<Aircrafts> findAllAircraftsQueryDsl(Session session)
    {

        return new JPAQuery<Aircrafts>(session)
                .select(QAircrafts.aircrafts)
                .from(QAircrafts.aircrafts)
                .fetch();
    }

    public String selectModelByIdQueryDsl(Session session,Long id)
    {
        return new JPAQuery<String>(session)
                .select(QAircrafts.aircrafts.model)
                .from(QAircrafts.aircrafts)
                .where(QAircrafts.aircrafts.id.eq(id)).fetchFirst();
    }

    public Integer selectRangeByIdQueryDsl(Session session,Long id)
    {
        return new JPAQuery<Integer>(session)
                .select(QAircrafts.aircrafts.range)
                .from(QAircrafts.aircrafts)
                .where(QAircrafts.aircrafts.id.eq(id)).fetchFirst();
    }

    public List<Aircrafts> selectAircraftsByRangeMoreQueryDsl(Session session,int MoreRange)
    {
       return new JPAQuery<Aircrafts>(session)
               .select(QAircrafts.aircrafts)
               .from(QAircrafts.aircrafts)
               .where(QAircrafts.aircrafts.range.gt(MoreRange)).fetch();

    }

    public List<Aircrafts> selectAircraftsBYModelNameQueryDsl(Session session,String ModelName)
    {
        return new JPAQuery<Aircrafts>(session)
                .select(QAircrafts.aircrafts)
                .from(QAircrafts.aircrafts)
                .where(QAircrafts.aircrafts.model.eq(ModelName)).fetch();
    }
}

package com.dinoelnirgihc.hibernatelearnfly;

import com.dinoelnirgihc.hibernatelearnfly.converter.CityConverter;
import com.dinoelnirgihc.hibernatelearnfly.entity.Aircrafts;
import com.dinoelnirgihc.hibernatelearnfly.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateRunner
{
    public static void main(String[] args)
    {
        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory())
        {
            Session session = sessionFactory.openSession();
        }
        catch(Exception e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

}

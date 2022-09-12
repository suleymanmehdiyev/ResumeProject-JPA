package com.company.impl;

import com.company.dao.inter.CityDAOInter;
import com.company.model.City;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CityDAOImpl extends AbstractDAO implements CityDAOInter {



    @Override
    public List<City> getAll() {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select city from City city");
        List<City> city = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return city;
    }

    @Override
    public City getById(Integer id) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select city from City city where city.id=:id");
        query.setParameter("id",id);
        City city = (City) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return city;
    }

    @Override
    public City addCity(City city) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        em.close();
        return city;
    }

    @Override
    public City updateCity(City city) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(city);
        em.getTransaction().commit();
        em.close();
        return city;
    }

    @Override
    public void deleteCity(Integer id) {
        EntityManager em = em();

        em.getTransaction().begin();
        City u = em.find(City.class,id);
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }
}

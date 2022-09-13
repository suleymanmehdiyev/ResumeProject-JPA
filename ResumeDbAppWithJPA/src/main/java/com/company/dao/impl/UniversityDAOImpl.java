package com.company.dao.impl;

import com.company.dao.inter.UniversityDAOInter;
import com.company.model.University;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UniversityDAOImpl extends AbstractDAO implements UniversityDAOInter {


    @Override
    public List<University> getAll() {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select uni from University uni");
        List<University> universities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return universities;
    }

    @Override
    public University getById(int id) {
        EntityManager em = em();

        University uni = em.find(University.class,id);
        em.close();
        return uni;
    }

    @Override
    public University addUniversity(University uni) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(uni);
        em.getTransaction().commit();
        em.close();
        return uni;
    }

    @Override
    public University updateUniversity(University uni) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(uni);
        em.getTransaction().commit();
        em.close();
        return uni;
    }

    @Override
    public void deleteUniversity(int id) {
        EntityManager em = em();

        em.getTransaction().begin();
        University uni = em.find(University.class,id);
        em.remove(uni);
        em.getTransaction().commit();
        em.close();
    }
}

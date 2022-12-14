package com.company.dao.impl;

import com.company.dao.inter.EducationDAOInter;
import com.company.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EducationDAOImpl extends AbstractDAO implements EducationDAOInter {

    @Override
    public List<Education> getAllEducationByUserId(User userId) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select edu from Education edu where edu.userId=:userId");
        query.setParameter("userId",userId);
        List<Education> edu = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return edu;
    }

    @Override
    public Education getEducationById(Integer id) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select edu from Education edu where edu.userId=:id");
        query.setParameter("id",id);
        Education edu = (Education) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return edu;
    }

    @Override
    public Education addEducation(Education education) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
        em.close();
        return education;
    }

    @Override
    public Education updateEducation(Education education) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(education);
        em.getTransaction().commit();
        em.close();
        return education;
    }


    @Override
    public void deleteEducationByUserId(User userId) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Education edu where edu.userId=:userId");
        query.setParameter("userId",userId);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}

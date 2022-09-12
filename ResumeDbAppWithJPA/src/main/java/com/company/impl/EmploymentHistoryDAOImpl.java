package com.company.impl;

import com.company.dao.inter.EmploymentHistoryDAOInter;
import com.company.model.EmploymentHistory;
import com.company.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmploymentHistoryDAOImpl extends AbstractDAO implements EmploymentHistoryDAOInter {

    @Override
    public List<EmploymentHistory> getAllEmploymentHistory(User userId) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select emp from EmploymentHistory emp where emp.userId=:userId");
        query.setParameter("userId",userId);
        List<EmploymentHistory> empHistory = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return empHistory;
    }

    @Override
    public EmploymentHistory getEmploymentHistoryById(Integer id) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select emp from EmploymentHistory emp where emp.id=:id");
        query.setParameter("id",id);
        EmploymentHistory empHistory = (EmploymentHistory) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return empHistory;
    }

    @Override
    public EmploymentHistory addEmploymentHistory(EmploymentHistory empHistory) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(empHistory);
        em.getTransaction().commit();
        em.close();
        return empHistory;
    }

    @Override
    public EmploymentHistory updateEmploymentHistory(EmploymentHistory empHistory) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(empHistory);
        em.getTransaction().commit();
        em.close();
        return empHistory;
    }

    @Override
    public void deleteEmploymentHistory(Integer id) {
        EntityManager em = em();

        em.getTransaction().begin();
        EmploymentHistory u = em.find(EmploymentHistory.class,id);
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }
}

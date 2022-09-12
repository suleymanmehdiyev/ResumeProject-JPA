package com.company.impl;

import com.company.dao.inter.UserSkillDAOInter;
import com.company.model.User;
import com.company.model.UserSkill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserSkillDAOImpl extends AbstractDAO implements UserSkillDAOInter {

    @Override
    public List<UserSkill> getAllUserSkill(User userId) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select us from UserSkill us where us.user=:userId");
        query.setParameter("userId",userId);
        List<UserSkill> userSkill = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return userSkill;
    }

    @Override
    public UserSkill getById(Integer id) {
        EntityManager em = em();

        UserSkill us = em.find(UserSkill.class,id);
        em.close();
        return us;
    }

    @Override
    public UserSkill addUserSkill(UserSkill userSkill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(userSkill);
        em.getTransaction().commit();
        em.close();
        return userSkill;
    }

    @Override
    public UserSkill updateUserSkill(UserSkill userSkill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(userSkill);
        em.getTransaction().commit();
        em.close();
        return userSkill;
    }

    @Override
    public void deleteUserSkill(Integer id) {
        EntityManager em = em();

        em.getTransaction().begin();
        UserSkill u = em.find(UserSkill.class,id);
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }
}

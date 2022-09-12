package com.company.impl;

import com.company.dao.inter.SkillDAOInter;
import com.company.model.Skill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SkillDAOImpl extends AbstractDAO implements SkillDAOInter {


    @Override
    public List<Skill> getAll() {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select s from Skill s");
        List<Skill> skills = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return skills;
    }

    @Override
    public Skill getById(int id) {
        EntityManager em = em();

        Skill s = em.find(Skill.class,id);
        em.close();
        return s;
    }

    @Override
    public Skill addSkill(Skill skill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
        em.close();
        return skill;
    }

    @Override
    public Skill updateSkill(Skill skill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
        em.close();
        return skill;

    }

    @Override
    public void deleteSkill(int id) {
        EntityManager em = em();

        em.getTransaction().begin();
        Skill s = em.find(Skill.class,id);
        em.remove(s);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Skill getByName(String name) {
        EntityManager em = em();
        String sql = "select s from Skill s where s.skillName=:name";
        Query query = em.createQuery(sql);
        query.setParameter("name",name);
        List<Skill> skillList = query.getResultList();
        if(skillList.size()==1){
            return skillList.get(0);
        }
        return null;
    }
}

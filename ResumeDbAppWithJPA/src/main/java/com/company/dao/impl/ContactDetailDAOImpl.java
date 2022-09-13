package com.company.dao.impl;

import com.company.dao.inter.ContactDetailDAOInter;
import com.company.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ContactDetailDAOImpl extends AbstractDAO implements ContactDetailDAOInter {

    @Override
    public List<ContactDetail> getAllContactDetail() {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select cd from ContactDetail cd");
        List<ContactDetail> cd = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return cd;
    }

    @Override
    public List<ContactDetail> getContactDetailById(User userId) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select cd from ContactDetail cd where cd.userId=:userId");
        query.setParameter("userId",userId);
        List<ContactDetail> cd = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return cd;
    }

    @Override
    public ContactDetail addContactDetail(ContactDetail contactDetail) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(contactDetail);
        em.getTransaction().commit();
        em.close();
        return contactDetail;
    }

    @Override
    public ContactDetail updateContactDetail(ContactDetail contactDetail) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(contactDetail);
        em.getTransaction().commit();
        em.close();
        return contactDetail;
    }

    @Override
    public void deleteContactDetailByUserId(User userId) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from ContactDetail cd where cd.userId=:userId");
        query.setParameter("userId",userId);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
